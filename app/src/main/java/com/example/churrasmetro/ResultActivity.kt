package com.example.churrasmetro

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

const val key_result_carne = "KEY RESULT CARNE"
const val key_result_cerveja = "KEY RESULT CERVEJA"
const val key_result_refri = "KEY RESULT REFRI"

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)


        val resultCarne = findViewById<TextView>(R.id.tvresult_carne)
        val resultCerveja = findViewById<TextView>(R.id.tvresult_cerveja)
        val resultRefrigerante = findViewById<TextView>(R.id.tvresult_refri)
        val btncalculo = findViewById<Button>(R.id.btn_calcularnovamente)


        val meat = intent.getFloatExtra(key_result_carne, 0f)
        val beer = intent.getFloatExtra(key_result_cerveja, 0f)
        val soda = intent.getFloatExtra(key_result_refri, 0f)



        resultCarne.text = "%.2f".format(meat)
        resultCerveja.text = "%.2f".format(beer)
        resultRefrigerante.text = "%.2f".format(soda)

        btncalculo.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

    }



}
