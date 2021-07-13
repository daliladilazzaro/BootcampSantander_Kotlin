package collections

fun main() {
    val pair: Pair<String, Double> = Pair("Stephan", 4500.00)
    val map1 = mapOf(pair)

    map1.forEach { (k, v) -> println("Chave: $k = Valor: $v") }

    println("--------------------------")
    val map2 = mapOf("Damon" to 5500.00, "Elena" to 7800.00)
    map2.forEach { (k, v) -> println("Chave: $k = Valor: $v") }
}