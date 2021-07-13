package com.example.calculadoranotas

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btmCalc = calcular
        val res = resultado

        btmCalc.setOnClickListener {
            val n1 = Integer.parseInt(nota1.text.toString())
            val n2 = Integer.parseInt(nota2.text.toString())
            val media = (n1+n2)/2
            val flt = Integer.parseInt(falta.text.toString())
            if (media >= 6 && flt <= 10){
                res.setText("APROVADX! \n Nota: "+media+"\n Faltas: "+flt)
                res.setTextColor(Color.GREEN)
            }else{
                res.setText("REPROVADX! \n Nota: "+media+"\n Faltas: "+flt)
                res.setTextColor(Color.RED)
            }
        }
    }
}