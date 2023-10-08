package com.example.tasklist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.appcompat.app.AlertDialog
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private val itemsList = mutableListOf<String>() // List to store entered text
    private lateinit var adapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val openDialogButton = findViewById<FloatingActionButton>(R.id.Fab)
        val listView = findViewById<ListView>(R.id.TaskList)

        // Initialize the adapter with your data list
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, itemsList)
        listView.adapter = adapter

        openDialogButton.setOnClickListener {
            showInputDialog()
        }
    }

    private fun showInputDialog() {
        val alertDialogBuilder = AlertDialog.Builder(this)
        alertDialogBuilder.setTitle("Adicionar Tarefa")

        val inputEditText = EditText(this)
        alertDialogBuilder.setView(inputEditText)

        alertDialogBuilder.setPositiveButton("Enviar") { dialog, which ->
            val userInput = inputEditText.text.toString()

            if (userInput.isNotEmpty()) {
                // Add the entered text to the list and update the adapter
                itemsList.add(userInput)
                adapter.notifyDataSetChanged()
            }

            dialog.dismiss()
        }

        val alertDialog = alertDialogBuilder.create()
        alertDialog.show()
    }
}