package collections

fun main() {
    val func = Funcionario("Carla", 1800.00, "PJ")
    val func1 = Funcionario("Carlos", 2000.00, "CLT")
    val func2 = Funcionario("Carmelia", 1500.00, "CLT")

    val funcinarios= listOf(func, func1, func2)

    funcinarios.forEach { println(it) }

    println("-------------------------")
    println(funcinarios.find { it.nome == "Carmelia" })

    println("-------------------------")
    funcinarios.sortedBy { it.salario }.forEach{println(it)}

    println("-------------------------")
    funcinarios.groupBy { it.tipo }.forEach{println(it)}
}

