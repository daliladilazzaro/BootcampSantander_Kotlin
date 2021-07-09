package bank.teste

import bank.Analista
import bank.Funcionario
import bank.Gerente

fun main() {
        val func = Gerente("Dalila Di Lazzaro", "456.789.123-00", 70000.00, "senha123")
        imprimeRelatorioFuncionario.imprime(func)
        TesteAutenticacao().autentica(func)
    }


