package com.example.churrasmetro

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        val edtadultos = findViewById<TextInputEditText>(R.id.edt_adultos)
        val edtcriancas = findViewById<TextInputEditText>(R.id.edt_criancas)
        val edtchurrasco = findViewById<TextInputEditText>(R.id.edt_churrasco)
        val btncalcular = findViewById<Button>(R.id.btn_calcular)


        btncalcular.setOnClickListener {
            if (edtadultos.text.toString() == "" || edtcriancas.text.toString() == "" ||
                edtchurrasco.text.toString() == ""
            ) {

                Snackbar.make(
                    edtadultos, "Preencha o campo vazio",
                    Snackbar.LENGTH_LONG
                ).show()

            } else {
                val adultos = edtadultos.text.toString().toFloatOrNull()
                val criancas = edtcriancas.text.toString().toFloatOrNull()
                val churrasco = edtchurrasco.text.toString().toFloatOrNull()

            }

        }


    }
}