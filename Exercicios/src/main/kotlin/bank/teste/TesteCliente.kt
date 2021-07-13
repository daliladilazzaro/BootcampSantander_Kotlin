package bank.teste

import bank.Cliente
import bank.ClienteEnum

fun main() {
    val cli=Cliente(nome = "Marcia Souza", cpf = "789.45.123-00", clienteEnum = ClienteEnum.PF, senha = "1234")
    println(cli)

    TesteAutenticacao().autentica(cli)
}