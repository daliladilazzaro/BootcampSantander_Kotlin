package bank.teste

import bank.Pessoa

fun main(){
    val pessoa = Pessoa(nome= "Lila Lazzaro", cpf = "123.456.789-00")
    println(pessoa.nome)
    println(pessoa.cpf)
}