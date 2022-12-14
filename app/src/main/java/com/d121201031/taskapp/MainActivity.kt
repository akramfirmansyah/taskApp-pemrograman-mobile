package com.d121201031.taskapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.d121201031.taskapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    lateinit var taskViewModel: TaskViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        taskViewModel = ViewModelProvider(this).get(TaskViewModel::class.java)
        val adapter = TaskAdapter(this)
        binding.recyclerView.adapter = adapter;
        binding.recyclerView.layoutManager = StaggeredGridLayoutManager(1, LinearLayout.VERTICAL)
        taskViewModel.getTaskData.observe(this) { task ->
            adapter.setData(task)
            adapter.notifyDataSetChanged()
        }
        binding.addTask.setOnClickListener(){
            startActivity(Intent(this, AddTaskActivity::class.java))
        }
    }
}