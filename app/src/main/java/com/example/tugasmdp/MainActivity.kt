package com.example.tugasmdp  // Ganti sesuai dengan nama package kamu

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tugasmdp.ui.theme.TugasMDPTheme  // Sesuaikan dengan nama tema di project-mu

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TugasMDPTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CurrencyConverter()
                }
            }
        }
    }
}

@Composable
fun CurrencyConverter() {
    var input by remember { mutableStateOf("") }
    var isEuroToRupiah by remember { mutableStateOf(true) }
    val exchangeRate = 17000.0

    val result = remember(input, isEuroToRupiah) {
        val amount = input.toDoubleOrNull()
        if (amount != null) {
            if (isEuroToRupiah) {
                "Rp %.2f".format(amount * exchangeRate)
            } else {
                "€ %.2f".format(amount / exchangeRate)
            }
        } else {
            "Masukkan angka yang valid"
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Konversi Mata Uang",
            style = MaterialTheme.typography.headlineSmall
        )

        OutlinedTextField(
            value = input,
            onValueChange = { input = it },
            label = {
                Text(
                    if (isEuroToRupiah) "Masukkan jumlah Euro"
                    else "Masukkan jumlah Rupiah"
                )
            },
            singleLine = true
        )

        Row(verticalAlignment = Alignment.CenterVertically) {
            Text("Konversi: ")
            Spacer(modifier = Modifier.width(8.dp))
            Switch(
                checked = isEuroToRupiah,
                onCheckedChange = { isEuroToRupiah = it }
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(if (isEuroToRupiah) "Euro → Rupiah" else "Rupiah → Euro")
        }

        Text(
            text = "Hasil: $result",
            fontSize = 18.sp
        )
    }
}
