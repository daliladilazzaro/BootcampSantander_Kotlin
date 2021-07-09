package bank.teste

import bank.Analista
import bank.Funcionario
import java.math.BigDecimal

fun main() {
    val func = Analista("Carla Gimenez", "987.654.321-00", 1500.00)
    imprimeRelatorioFuncionario.imprime(func)

}
    //fun imprimirRelatorio(funcionario: Funcionario) = println(funcionario.toString())
