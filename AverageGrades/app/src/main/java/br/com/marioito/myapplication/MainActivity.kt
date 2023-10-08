package br.com.marioito.myapplication

import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.internal.ViewUtils.hideKeyboard

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val grade1 = findViewById<EditText>(R.id.Grade1)
        val grade2 = findViewById<EditText>(R.id.Grade2)
        val grade3 = findViewById<EditText>(R.id.Grade3)
        val grade4 = findViewById<EditText>(R.id.Grade4)
        val calculateButton = findViewById<Button>(R.id.Calculate)
        val resetButton = findViewById<Button>(R.id.Reset)
        val averageText = findViewById<TextView>(R.id.averageText)
        val resultImage = findViewById<ImageView>(R.id.resultImage)

        calculateButton.setOnClickListener {
            if (grade1.text.isEmpty() || grade2.text.isEmpty() ||
                grade3.text.isEmpty() || grade4.text.isEmpty()) {
                // Show a Toast message indicating that all fields must be filled
                Toast.makeText(this, "Preencha todos os campos de Nota!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val g1 = grade1.text.toString().toFloatOrNull() ?: 0f
            val g2 = grade2.text.toString().toFloatOrNull() ?: 0f
            val g3 = grade3.text.toString().toFloatOrNull() ?: 0f
            val g4 = grade4.text.toString().toFloatOrNull() ?: 0f

            val average = (g1 + g2 + g3 + g4) / 4
            averageText.text = "Média: $average"
            if (average < 6) {
                resultImage.setImageResource(R.drawable.sad)
            } else {
                resultImage.setImageResource(R.drawable.happy)
            }
            resultImage.visibility = ImageView.VISIBLE

            hideKeyboard(it)

            grade1.isEnabled = false
            grade2.isEnabled = false
            grade3.isEnabled = false
            grade4.isEnabled = false
        }

        resetButton.setOnClickListener {
            grade1.text.clear()
            grade2.text.clear()
            grade3.text.clear()
            grade4.text.clear()
            averageText.text = "Média"

            grade1.isEnabled = true
            grade2.isEnabled = true
            grade3.isEnabled = true
            grade4.isEnabled = true

            resultImage.visibility = ImageView.INVISIBLE
        }
    }

    private fun Activity.hideKeyboard(view: View) {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}