package collections

fun main() {
    val salario = doubleArrayOf(2500.68, 150.40, 489.00)

    for (sal in salario){
        println(sal)
    }

    println("---------------------------")
    println("O maior salário é: ${salario.maxOrNull()}")
    println("O menor salário é: ${salario.minOrNull()}")
    println("O média salário é: ${salario.average()}")


    println("-------------------------")

    val salarioMaior160 = salario.filter { it > 160.0 }
    salarioMaior160.forEach{println(it)}
}