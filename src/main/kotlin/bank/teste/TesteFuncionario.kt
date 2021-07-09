package bank.teste

import bank.Funcionario
import bank.Pessoa
import java.math.BigDecimal

fun main(){
    val pessoa = Pessoa(nome= "Lila Lazzaro", cpf = "123.456.789-00")
    println(pessoa.nome)
    println(pessoa.cpf)

    val func=Funcionario("Carla Gimenez", "987.654.321-00", BigDecimal.valueOf(1500.00))
    println(func.nome)
    println(func.cpf)
    println(func.salario)
}