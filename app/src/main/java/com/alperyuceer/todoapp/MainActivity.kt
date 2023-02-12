package com.alperyuceer.todoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.alperyuceer.todoapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var gorevListesi: ArrayList<String>
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: TaskAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        gorevListesi = ArrayList<String>()

        adapter = TaskAdapter(gorevListesi)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter

    }

    fun gorevEkle(view: View){
        val yeniGorev = binding.taskEditView.text.toString()
        gorevListesi.add(yeniGorev)
        binding.taskEditView.text.clear()
        adapter.notifyDataSetChanged()
    }
}