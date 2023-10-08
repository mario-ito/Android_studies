package br.com.marioito.celsiustofahrenheit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val celsiusSeekBar = findViewById<SeekBar>(R.id.celsiusSeekBar)
        val celsiusLabel = findViewById<TextView>(R.id.celsiusLabel)
        val fahrenheitLabel = findViewById<TextView>(R.id.fahrenheitLabel)

        celsiusSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                val celsiusValue = progress
                val fahrenheitValue = (celsiusValue * 9/5) + 32

                celsiusLabel.text = "Celsius: $celsiusValue°C"
                fahrenheitLabel.text = "Fahrenheit: $fahrenheitValue°F"
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        })
    }
}