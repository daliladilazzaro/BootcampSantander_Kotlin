package collections

fun main() {
    val func = Funcionario("Carla", 1800.00, "PJ")
    val func1 = Funcionario("Carlos", 2000.00, "CLT")
    val func2 = Funcionario("Carmelia", 1500.00, "CLT")

    val repositorio = Repositorio<Funcionario>()

    repositorio.create(func.nome, func)
    repositorio.create(func1.nome, func1)
    repositorio.create(func2.nome, func2)

    println(repositorio.findById(func.nome))

    println("-------------------")
    repositorio.findAll().forEach{println(it)}

    println("-------------------")
    repositorio.remove(func1.nome)
    repositorio.findAll().forEach{println(it)}
}