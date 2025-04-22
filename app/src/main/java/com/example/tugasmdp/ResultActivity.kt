package com.example.tugasmdp

import android.os.Bundle
import android.widget.TextView
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {
    private lateinit var resultTextView: TextView
    private lateinit var backButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        resultTextView = findViewById(R.id.hasilTextView)
        backButton = findViewById(R.id.backButton)

        val amount = intent.getStringExtra("amount")
        val mode = intent.getStringExtra("mode")
        val result = intent.getDoubleExtra("result", 0.0)

        val modeText = if (mode == "1") "Euro ke Rupiah" else "Rupiah ke Euro"
        resultTextView.text = "Konversi $modeText\nJumlah: $amount\nHasil: $result"

        backButton.setOnClickListener {
            finish()
        }
    }
}
