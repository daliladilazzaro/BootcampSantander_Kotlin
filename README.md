# Curso Santander Bootcamp de Mobile Developer - Kotlin

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
- O ***Data Class*** é uma classe que espera dados, ter informações para seguir a longo da aplicação. O Data class pode implementar interface e com o uso de copy pode-se obter uma nova instancia e então alterar nessa instancia o estado do objeto
- O ***Enum Class*** é uma classe com opção de termos um construtor primário a sua propriedade, com objetos e instâncias da própria classe que podem já ser declaradas, destinada para tipos dentro de uma função, por exemplo, para uma classe Cliente, existem dois parametros Pessoa Física e Juridica, ao invés de fazer apenas uma variavel destinada para isso, o que pode ocorrer muitas vezes erro em digitação, já temos nossos enuns que permite já sigras prontas para escolher. Permitindo também ```companion object``` que nos da a opção para funções estáticas, ou seja, via classe, e não via instância do objeto. Assim como qualquer classe, uma enum pode ter construtor e propriedade.

Sendo as classes um artefato que permite representar uma abstração do mundo real. Portanto, a maneira correta sobre uma explicação dos membros de uma classe é que elas possuem ***propriedades, construtores e funções de uma classe***. O Kotlin é uma liguaguem orientada a objetos, que utilizamos o paradigma orientado a objetos para definirmos classes, propriedades e métodos que representem uma situação real

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

### Herança
No Kotlin, para que uma classe seja aberta, usamos a palavra reservada ```open```, o que facilita quando for trabalhar com **herança**, assim, a classe que irá herdar terá que manter seus atributos com ```overrode```. Além da Herança ser um mecanismo que permite que características comuns a diversas classes sejam fatoradas em uma classe base, ou superclasse. A partir de uma classe base, outras classes podem ser especificadas. Além de que uma classe abstrata pode herdar de uma única outra classe abstrata e implementar várias interfaces. E uma classe base é a classe que concede as características e a sub-classe herda as características da classe base.

#### Classe mãe
```Kotlin
open class Pessoa (open val nome:String,open val cpf:String)
```
#### Classe herdada (filho)
```Kotlin
class Funcionario(override val nome:String, override val cpf:String): Pessoa(nome, cpf)
```
Diferente de uma classe ```abstract``` que não instancia, sua dinamica é diferente. No lugar do **open**, segue o abstract.

Quando usamos ```abstract``` há momentos que também precisamos usar o ```protected``` fazendo que as classes mãe e filhas consigam fazer uso do argumento.

#### Classe mãe
``` kotlin
abstract class Funcionario( nome:String, cpf:String, val salario:Double): Pessoa(nome, cpf){
protected abstract fun calculoAuxilio():Double

    override fun toString(): String = """
        Nome: $nome
        CPF: $cpf
        Salário: $salario
        Auxílio: ${calculoAuxilio()}
        """.trimIndent()
}
```

#### Classe filho
``` kotlin
class Gerente(nome: String, cpf: String, salario: Double) : Funcionario(nome, cpf, salario) {
    override fun calculoAuxilio(): Double = salario*0.4
}
```
### Polimorfismo 
Como não é possível herdar duas vezes, é onde entra o polimorfismo usando ```interface```, e toda **interface** é abstrata, não sendo necessário inclui-la. E também não há necessidade em informar "()" pois ela não precisa de construtor, ou de instânciar. Em programação orientada a objetos, polimorfismo é o princípio pelo qual duas ou mais classes derivadas da mesma superclasse podem invocar métodos que têm a mesma assinatura, mas comportamentos distintos

#### Classe com interface
```kotlin
interface Login {
    fun login(): Boolean
}
```
Uma Interface pode extender de outras interfaces.

#### Classe herdada
```kotlin
class Cliente(nome: String, cpf: String, val clienteEnum: ClienteEnum, val senha:String)
    :Pessoa(nome, cpf),Login {
    override fun login(): Boolean = "1234" == senha

    override fun toString(): String = """
        Nome: $nome
        CPF: $cpf
        Tipo: $clienteEnum
        """.trimIndent()
}
```

## Sobre a Arquitetura

- O Google Play Instant, permite que aplicativos e jogos nativos sejam iniciados em dispositivos com Android 5.0 (API de nível 21) ou superior sem serem instalados.

- Sobre a segurança do sistemas e o Armazenamento de dados, por padrão, os arquivos criados no armazenamento interno podem ser acessados apenas pelo seu app. O Android implementa essa proteção e é suficiente para a maioria dos aplicativos.

- As camadas da arquitetura android estão relacionada às Estrutura da Java API.

- As plataformas Android contém camada mais próxima dos desenvolvedores é a camada de Aplicação

- A camada mais próxima dos desenvolvedores de aplicativos é a camada dos Aplicativos do sistema

- As DSUs dependem do recurso de partição dinâmica do Android e exigem que as GSIs sejam assinadas pelo Google ou pelos seus OEMs como uma imagem de sistema confiável.

- As atualizações dinâmicas do sistema (DSU)  são um recurso do sistema lançado no Android 10.

- A imagem genérica do sistema (GSI) é uma implementação de Android puro e pode ser executada em vários dispositivos Android.

## Fontes
- [AndroidStudioOnline](https://play.kotlinlang.org/#eyJ2ZXJzaW9uIjoiMS41LjIwIiwicGxhdGZvcm0iOiJqYXZhIiwiYXJncyI6IiIsImpzQ29kZSI6IiIsIm5vbmVNYXJrZXJzIjp0cnVlLCJ0aGVtZSI6ImlkZWEiLCJjb2RlIjoiLyoqXG4gKiBZb3UgY2FuIGVkaXQsIHJ1biwgYW5kIHNoYXJlIHRoaXMgY29kZS4gXG4gKiBwbGF5LmtvdGxpbmxhbmcub3JnIFxuICovXG5cbmZ1biBtYWluKCkge1xuICAgIHByaW50bG4oXCJIZWxsbywgd29ybGQhISFcIilcbn0ifQ==)
- [GoogleDeveloper](https://developers.google.com/android/play-protect/starting-a-vdp)
- [AndroidDeveloper](https://developer.android.com/studio/preview)
- [AndroidDeveloper](https://developer.android.com/security)
- [AndroidDeveloper](https://developer.android.com/platform/technology/app-bundle)
- [DigitalInnovationOne](https://web.digitalinnovation.one/track/santander-mobile-developer?tab=path)

## Authors 👩‍💻💖

- [@daliladilazzaro](https://github.com/daliladilazzaro)
