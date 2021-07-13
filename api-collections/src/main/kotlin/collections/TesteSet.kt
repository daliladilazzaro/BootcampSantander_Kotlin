package collections

fun main() {
    val func = Funcionario("Carla", 1800.00, "PJ")
    val func1 = Funcionario("Carlos", 2000.00, "CLT")
    val func2 = Funcionario("Carmelia", 1500.00, "CLT")

    val funcion1 = setOf(func, func1)
    val funcion2= setOf(func2)

    val resUniao = funcion1.union(funcion2)
    resUniao.forEach{println(it)}

    println("-------------------------")

    val funcion3 = setOf(func, func1, func2)
    val resSubtract = funcion3.subtract(funcion2)
    resSubtract.forEach{println(it)}

    println("-------------------------")


    val resIntersect= funcion3.intersect(funcion2)
    resIntersect.forEach{println(it)}
}