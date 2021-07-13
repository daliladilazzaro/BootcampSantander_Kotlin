package collections

fun main() {
    val salario = DoubleArray(2)

    salario[0] = 32587.45
    salario[1] = 7852.99

    salario.forEach { println(it) }
    println("-------------------------")
    salario.forEachIndexed{ index, salarios ->
        salario[index] = salarios * 1.1
    }
    salario.forEach { println(it) }

    println("-------------------------")

    val salario2 = doubleArrayOf(999994526.68, 115456464.98)

    salario2.sort()
    salario2.forEach { println(it) }
}