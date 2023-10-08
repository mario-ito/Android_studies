package br.com.marioito.megasena

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private val randomNumbersSet = mutableSetOf<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val drawButton = findViewById<Button>(R.id.drawButton)
        val resetButton = findViewById<Button>(R.id.resetButton)

        // Set click listeners for the buttons
        drawButton.setOnClickListener {
            drawRandomNumbers()
        }

        resetButton.setOnClickListener {
            resetNumbers()
        }
    }

    private fun drawRandomNumbers() {
        // Clear previous numbers
        randomNumbersSet.clear()

        // Generate 6 unique random numbers
        while (randomNumbersSet.size < 6) {
            val randomNumber = Random.nextInt(1, 50) // Generate random number between 1 and 49
            randomNumbersSet.add(randomNumber)
        }

        // Display the random numbers in TextViews
        displayNumbers()
    }

    private fun displayNumbers() {
        val textViewIds = arrayOf(
            R.id.number1, R.id.number2, R.id.number3, R.id.number4, R.id.number5, R.id.number6
        )

        for ((index, number) in randomNumbersSet.sorted().withIndex()) {
            val textView = findViewById<TextView>(textViewIds[index])
            textView.text = number.toString()
        }
    }

    private fun resetNumbers() {
        // Clear the random numbers and TextViews
        randomNumbersSet.clear()

        val textViewIds = arrayOf(
            R.id.number1, R.id.number2, R.id.number3, R.id.number4, R.id.number5, R.id.number6
        )

        for (textViewId in textViewIds) {
            val textView = findViewById<TextView>(textViewId)
            textView.text = ""
        }
    }
}