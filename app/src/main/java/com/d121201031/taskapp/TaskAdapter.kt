package com.d121201031.taskapp

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TaskAdapter(
    private val context: MainActivity,
): RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {
    private var dataset = emptyList<TaskModel>()
    lateinit var taskViewModel: TaskViewModel


    class TaskViewHolder( val view: View): RecyclerView.ViewHolder(view){
        val taskTitle = view.findViewById<TextView>(R.id.taskTitle)
        val taskDescrition = view.findViewById<TextView>(R.id.taskDescription)
        val taskUrgency = view.findViewById<TextView>(R.id.taskUrgency)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_task_list, parent, false)
        return TaskViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val item =dataset[position]
        holder.taskTitle.text = item.title
        holder.taskDescrition.text = item.description
        holder.taskUrgency.text = item.urgency
        when(item.urgency){
            context.getString(R.string.urgency1)-> holder.taskUrgency.setTextColor(Color.parseColor("#ff0000"))
            context.getString(R.string.urgency2)-> holder.taskUrgency.setTextColor(Color.parseColor("#fcc203"))
            context.getString(R.string.urgency3)-> holder.taskUrgency.setTextColor(Color.parseColor("#23f507"))
            else-> holder.taskUrgency.setTextColor(Color.parseColor("#666666"))
        }
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    fun setData(task: List<TaskModel>){
        this.dataset = task
    }

}