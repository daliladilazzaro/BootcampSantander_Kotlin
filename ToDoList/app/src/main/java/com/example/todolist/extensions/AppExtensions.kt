package com.example.todolist.extensions

import com.google.android.material.textfield.TextInputLayout
import java.text.SimpleDateFormat
import java.util.*

private val locale= Locale("pt", "BR")

fun Date.format(): String{
    return SimpleDateFormat("dd/mm/yyyy", locale).format(this)
}

var TextInputLayout.text : String
//nao pode ser nula, então pode retornar vazio
    get() = editText?.text?.toString()?: ""
    set(value){
        editText?.setText(value)
    }