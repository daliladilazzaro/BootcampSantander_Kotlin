package com.everis.bootcamp.threading

import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.Request

//criado no layout
//TODO: 010 - Criar a classe responsável por carregar os dados
class AstrosRepository {

    //TODO: 011 - Criar função para carregar os astronautas
    fun loadData():List<AstrosPeople>{
        val client=OkHttpClient()
        val resquest=Request.Builder().url("http://api.open-notify.org/astros.json").build()
        val response = client.newCall(resquest).execute()
        val result=parseJsonResult(response.body?.string())
        return  result.people
    }
    //TODO: 012 - Criar função para converter o json
    fun parseJsonResult(json:String?)= Gson().fromJson(json, AstrosResult::class.java)

}