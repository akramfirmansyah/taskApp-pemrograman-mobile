package com.d121201031.taskapp;

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.iterator
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.d121201031.taskapp.databinding.ActivityAddTaskBinding

class AddTaskActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddTaskBinding
    lateinit var taskViewModel: TaskViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAddTaskBinding.inflate(layoutInflater)
        setContentView(binding.root)
        taskViewModel = ViewModelProvider(this).get(TaskViewModel::class.java)
        binding.addTaskButton.setOnClickListener(){
            createTask()
            finish()
        }
    }

    fun createTask(){
        var title: String = binding.titleInput?.text.toString()
        if(title.isEmpty()){
            title = getString(R.string.no_title)
        }
        var desc: String = binding.descriptionInput?.text.toString()
        if(desc.isEmpty()){
            desc = getString(R.string.no_description)
        }
        val urgency: String = when(binding.urgencyOptions.checkedRadioButtonId){
            R.id.urgency1 -> getString(R.string.urgency1)
            R.id.urgency2 -> getString(R.string.urgency2)
            R.id.urgency3 -> getString(R.string.urgency3)
            else -> getString(R.string.urgency4)
        }
        taskViewModel.addTask(TaskModel(title,desc, urgency))
    }
}