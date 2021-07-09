# Exercícios do curso Santander Bootcamp de Mobile Developer - Kotlin

### Conceitos básicos do Kotlin

- Para variáveis que podem ser alteradas em momentos futuros pode se usar: **var**. 
- Para variáveis que **não** podem ser alteradas, a não ser que vá até a raiz: **val**

### Exemplo de função 
``` kotlin
class Pessoa {
    var nome:String="Lila"
    var cpf:String="123.456.789.90"

}

fun main (){
    val lila = Pessoa()

    print(lila.nome)
    print(lila.cpf)
}
```

Para informar uma classe dentro de uma classe: 
``` Kotlin
inner class Endereco {
        var rua:String="Rua exemplo"
    }
```
Como vimos no exemplo que para a variável se tornal imutável utilizar **val**, podemo usar também ```private set``` abaixo da declaração de variáveis.   

### Membros de uma classe
Os membros de uma classe são ***construtor primário ou secundário*** como ``` constructor()```, ***propriedades*** como ``` var nome:String="Lila"```, e até uma função dentro de uma função como ```fun pessoaInfo()= println("$nome e $cpf")``` .

As funções trabalham dentro da classe que abstrai algo do "mundo real", as funções permitem os objetos terem comportamentos, e as propriedades permitem terem um estado para quando instanciar ele tem a variavel no caso do exemplo acima "lila" que possui um comportamento que trás as informações dele. Esses são os membros de uma classe. 

### Tipo de Class
- O ***Data Class*** é uma classe que espera dados, ter informações para seguir a longo da aplicação. 
- O ***Enum Class*** é uma classe destinada para tipos dentro de uma função, por exemplo, para uma classe Cliente, existem dois parametros Pessoa Física e Juridica, ao invés de fazer apenas uma variavel destinada para isso, o que pode ocorrer muitas vezes erro em digitação, já temos nossos enuns que permite já sigras prontas para escolher. Permitindo também ```companion object``` que nos da a opção para funções estáticas, ou seja, via classe, e não via instância do objeto. 

### Alterar um tipo "Val"
Como vimos, o tipo de variável ***val*** é imutável. Mas existe uma condição chamada **copy** que cria uma cópia de uma variável que contem ela, e pode ser alterada, conforme: 

``` kotlin
package bank.teste

import bank.Banco

fun main() {
    val bank = Banco("Banco Internacional", 1)

    println(bank.nome)
    println(bank.numero)

    val bank2 = bank.copy(numero = 2, nome = "Banco Nacional")

    println(bank2.nome)
    println(bank2.numero)
}
```
