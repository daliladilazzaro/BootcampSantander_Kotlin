package bank

class Pessoa {
    var nome:String="Lila"
    var cpf:String="123.456.789.90"
private set

    constructor()

    fun pessoaInfo()= println("$nome e $cpf")

    inner class Endereco{
        var rua:String="Rua ruarua"
    }
}

fun main (){
    val lila = Pessoa()

    println(lila.pessoaInfo())

}