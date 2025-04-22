package com.example.tugasmdp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var inputAmount: EditText
    private lateinit var inputMode: EditText
    private lateinit var convertButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        inputAmount = findViewById(R.id.inputAmount)
        inputMode = findViewById(R.id.inputMode)
        convertButton = findViewById(R.id.convertButton)

        convertButton.setOnClickListener {
            val amount = inputAmount.text.toString().trim()
            val mode = inputMode.text.toString().trim()
            val exchangeRate = 17000.0

            if (amount.isNotEmpty() && mode.isNotEmpty()) {
                val amountDouble = amount.toDoubleOrNull() ?: 0.0
                val result = if (mode == "1") {
                    amountDouble * exchangeRate
                } else {
                    amountDouble / exchangeRate
                }

                val intent = Intent(this@MainActivity, ResultActivity::class.java)
                intent.putExtra("amount", amount)
                intent.putExtra("mode", mode)
                intent.putExtra("result", result)
                startActivity(intent)
            }
        }
    }
}
