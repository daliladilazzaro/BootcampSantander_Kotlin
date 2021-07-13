package bank

class Cliente(nome: String, cpf: String, val clienteEnum: ClienteEnum, val senha:String)
    :Pessoa(nome, cpf),Login {
    override fun login(): Boolean = "1234" == senha

    override fun toString(): String = """
        Nome: $nome
        CPF: $cpf
        Tipo: $clienteEnum
        """.trimIndent()
}