package collections

fun main() {
    val func = Funcionario("Carla", 1800.00, "PJ")
    val func1 = Funcionario("Carlos", 2000.00, "CLT")
    val func2 = Funcionario("Carmelia", 1500.00, "CLT")

    val funcionarios = mutableListOf(func, func1)
    funcionarios.forEach{println(it)}

    println("-------List--------")

    funcionarios.add(func2)
    funcionarios.forEach{println(it)}

    println("---------------")

    funcionarios.remove(func)
    funcionarios.forEach{println(it)}

    println("-------Set--------")
    val funcSet = mutableSetOf(func)
    funcSet.forEach{println(it)}
    println("---------------")
    funcSet.add(func1)
    funcSet.add(func2)
    funcSet.forEach{println(it)}

    println("---------------")
    funcSet.remove(func)
    funcSet.forEach{println(it)}

}