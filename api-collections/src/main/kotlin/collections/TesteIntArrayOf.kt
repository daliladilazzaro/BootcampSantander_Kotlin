package collections

fun main() {
    val valor= intArrayOf(2,4,9,7,3,87,5)

    valor.forEach {
        println(it)
    }
    println("-------------")
    valor.sort()
    valor.forEach {
        println(it)
    }
}