package collections

fun main() {
    val nome = Array<String>(3){""}

    nome[0] = "Lila"
    nome[1] = "Di"
    nome[2] = "Lazzaro"
    for (nomes in nome){
        println(nomes)
    }
    println("-------------------------")
    nome.sort()
    nome.forEach {println(it)}
    println("-------------------------")

    val nome2 = arrayOf("Dalila", "Lazzaro", "Di")
    for (nomes in nome2){
        println(nomes)
    }
    println("-------------------------")
    nome2.sort()
    nome2.forEach {println(it)}

}