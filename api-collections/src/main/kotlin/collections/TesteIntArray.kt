package collections

fun main() {
    val valor=IntArray(5)

    valor[0] = 1
    valor[1] = 7
    valor[2] = 4
    valor[3] = 90
    valor[4] = 8

    for (valores in valor){
        println(valores)
    }
    println("-------------------------")
    valor.forEach {
        println(it)
    }
    println("-------------------------")
    for (i in valor.indices){
        println(valor[i])
    }
    println("-------------------------")
    valor.sort()
    for (valores in valor){
        println(valores)
    }
}