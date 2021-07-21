package com.example.vmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    lateinit var txtContador: EditText
    lateinit var btnDados: Button
    lateinit var btnMostrar: Button

    lateinit var mViewModel: MainView

   // var cont:Int = 0

    //a aplicação sempre passa por aqui primeiro, o nosso layout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //logar(valor = "onCreate")

        initDados()
      //  initContador()
        initClick()

       // validaContador()
    }

    /**override fun onStart() {
        logar(valor = "onStart")
        super.onStart()
    }

    override fun onResume() {
        logar(valor = "onResume")
        super.onResume()
    }

    override fun onPause() {
        logar(valor = "onPause")
        super.onPause()
    }

    override fun onStop() {
        logar(valor = "onStop")
        super.onStop()
    }

    override fun onDestroy() {
        logar(valor = "onDestroy")
        super.onDestroy()
    }

    private fun logar(tag: String = "Ciclo de vida", valor: String){
        Log.d(tag, valor)
    }

    private fun validaContador() {
        if (cont > 5) {
            cont = 0
        }
    }*/

    private fun initClick() {
        btnDados.setOnClickListener{
           // cont++
            //validaContador()
            //initContador()
            mViewModel.contador()
        }
        btnMostrar.setOnClickListener{
            //Toast.makeText(this,"Valor contador: ${cont.toString()}", Toast.LENGTH_SHORT).show()
            Toast.makeText(applicationContext,"Valor contador: ${mViewModel.mContador.value}", Toast.LENGTH_SHORT).show()
        }
    }

   /* private fun initContador() {
        txtContador.setText(cont.toString())
    }*/

    private fun initDados() {
        mViewModel = ViewModelProvider(this).get(MainView::class.java)

        txtContador = findViewById(R.id.txtContador)
        btnDados = findViewById(R.id.btnDados)
        btnMostrar = findViewById(R.id.btnMostrar)

        mViewModel.mContador.observe(this, Observer {
            txtContador.setText(it)
        })
    }
}