package bank.teste

import bank.ClienteEnum

fun main(){
    ClienteEnum.values().forEach {
        println("${it.name} - ${it.toString()}")
    }

    ClienteEnum.values().forEach { elemento ->
        println("${elemento.name} - ${elemento.descricao}")
    }

    val pf = ClienteEnum.PF
    println("${pf.name} - ${pf.descricao}")
    val pj = ClienteEnum.PJ
    println("${pj.name} - ${pj.descricao}")
}