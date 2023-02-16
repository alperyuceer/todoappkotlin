package com.alperyuceer.todoapp

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alperyuceer.todoapp.databinding.RecyclerviewRowBinding

class TaskAdapter(val taskList: MutableList<String>):RecyclerView.Adapter<TaskAdapter.TaskHolder>() {

    class TaskHolder(val binding: RecyclerviewRowBinding):RecyclerView.ViewHolder(binding.root){
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskHolder {
        val binding = RecyclerviewRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return TaskHolder(binding)
    }

    override fun getItemCount(): Int {
        return taskList.size

    }

    override fun onBindViewHolder(holder: TaskHolder, position: Int) {
        holder.binding.rvTaskTitle.text = taskList.get(position)
        holder.binding.rvDoneView.setOnClickListener {
            taskList.removeAt(position)
            notifyDataSetChanged()
        }
    }
}