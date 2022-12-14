package com.d121201031.taskapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TaskViewModel(application: Application): AndroidViewModel(application) {
    val getTaskData: LiveData<List<TaskModel>>
    val repository: TaskRepository

    init {
        val taskDao = AppDatabase.getDatabase(application).taskDao()
        repository = TaskRepository(taskDao)
        getTaskData = repository.readAllData
    }

    fun addTask(task: TaskModel){
        viewModelScope.launch(Dispatchers.IO){
            repository.addTask(task)
        }
    }
}