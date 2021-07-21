package com.example.vmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

//ela é útil pois quando mudar o estado do app de em pé para deitado, ele nao perde os valores que ele obteve
class MainView: ViewModel() {
    var mContador = MutableLiveData<String>().apply { value = cont.toString() }

    private var cont:Int = 0

    private fun setContador(){
        mContador.value = cont.toString()

    }

    private fun validaContador() {
        cont++
        if (cont > 5) {
            cont = 0
        }
        setContador()
    }

    fun contador(){
        validaContador()
    }

}