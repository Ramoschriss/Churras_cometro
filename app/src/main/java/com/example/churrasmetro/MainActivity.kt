package com.example.churrasmetro

import android.content.Intent
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

                val carnePoradulto: Float = 0.4f // Em kilos
                val carnePorcrianca: Float = 0.2f // Em kilos
                val cervejaPoradulto: Float = 1.5f // Em litros
                val refriPoradultos: Float = 0.7f // Em litros
                val refriPorcriancas: Float = 0.4f // Em litros


                val adultos = edtadultos.text.toString().toFloat()
                val criancas = edtcriancas.text.toString().toFloat()
                val churrasco = edtchurrasco.text.toString().toFloat()


                val carneTotal = (adultos * carnePoradulto) + (criancas * carnePorcrianca)
                val cervejaTotal = adultos * cervejaPoradulto
                val refriTotal = (adultos * refriPoradultos) + (criancas * refriPorcriancas)

                println(refriTotal)
                println(cervejaTotal)
                println(carneTotal)

                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra(key_result_carne, carneTotal)
                intent.putExtra(key_result_cerveja, cervejaTotal)
                intent.putExtra(key_result_refri, refriTotal)
                startActivity(intent)
            }

        }


    }
}