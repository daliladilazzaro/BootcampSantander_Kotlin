# Curso Santander Bootcamp de Mobile Developer - Kotlin

### Conceitos básicos do Kotlin

- Para variáveis que podem ser alteradas em momentos futuros pode se usar: **var**. 
- Para variáveis que **não** podem ser alteradas, a não ser que vá até a raiz: **val**.
- Quando se prepara um layout e configura o tamanho da letra, pode-se usar o padrão **"dp"** ou **"sp"**. O ***sp*** é para quando o usuário aumentar a tela, ele se ajustar e aumentar junto com a tela. Para uma letra de tamanho fixo, onde o usuário aumente a tela, e ele permaneça o mesmo tamanho já definido, usar o ***dp***.
- Devido a ausência de clickListeners e TextListeners, o first run do app não permitiu com que o IMC fosse calculado.
- Os seguintes tipos de layout organiza seus elementos baseado nos atributos orientation, gravity e layout_gravity é o Linear Layout.
- O atributo que define se elementos de um LinearLayout serão organizados verticalmente ou horizontalmente e chamado de Orientation.
- O cenário ideal para a utilização de um frameLayout é quando só há um elemento a ser exibido.
- Toda view possui um método onClickListener associado.
- build.gradle (module) dentro de dependencies{} é onde são declaradas as importações de bibliotecas nativas e externas do projeto.
- Após o onDestroy() o ciclo de vida é finalizado.
- Os seguintes métodos fazem parte do ciclo visível de uma Activity são OnCreate, OnStart, OnResume.
- São atributos característicos do Relative Layout: Start_To_end_of,End_To_start_of,above, below.
- Toolbar.xml não é um arquivo xml gerado junto com o projeto.
- A função do método commit no SharedPreferences é executar uma ação de confirmação de imediato bloqueando a thread atual.
- O método da interface de menu de opções conseguimos obter o evento de click sobre os itens é o onOptionsItemSelected().
- Por convenção, o arquivo de strings do módulo é onde devemos armazenar textos que serão utilizados em nossa aplicação Android.
- É obrigatório passar no mínimo 1 parâmetro no método de abertura de uma nova Activity, que é o objeto Intent() com informações refente à nova atividade que será aberta.
- RecyclerView é componente Android utilizamos para criar uma lista.
- No pacote res é onde deve ser guardado os arquivos de recursos de um módulo.
- AndroidManifest é o nome do arquivo onde registramos novas Activities em um módulo Android.
- O método utilizamos para acessar valores guardados com tipo string no SharedPreferences é o getString().
- Em componentes do projeto é onde podemos utilizar Styles em nosso projeto Android.
- O método que utilizamos para iniciar uma Activity em um módulo Android é o startActivity().
- Mantem o valor da variável na viewmodel quando o celular é rotacionando.
- Para inicializar uma variável com o LiveData com o valor “Init”, segue o comando: `var mContador = MutableLiveData<String>().apply { value = “Init” }`.
- ViewModel é um componente e Arquitetura.
- Uma ViewModel nos permitem modelar várias entidades a partir de um ou mais modelos em um único objeto.
- Para estanciar uma Class ViewModel se faz com `viewModel = ViewModelProvider(this).get(MainViewModel::class.java)`
- A função do meu Observer serve para notificar quando um objeto muda de estado.
- Em um projeto, não precisa utilizar o ViewModel.
- É importante identificar o ContentProvider, pois o endereço de identificação possibilita a realização das operações definidas do ContentProvider.
- o Content Provider é um provedor de conteúdo, onde permite compartilhar informações de uma aplicação com outras aplicações.
- A função de uma Notification é ser uma mensagem que Android exibe fora da interface do app.
- Afunção do LoaderManager é realizar as operações do Content Provider em segundo plano, para que não haja problemas de performance.
- Um Retrofit serve para fornecer um padrão simples de implementação para o consumo de uma API.
- A importância de um model para se trabalhar com uma API, é ser um objeto responsável pelo mapeamento do retorno da API.
- A importância de se trabalhar com uma API é permite consumir os dados de uma conexão externa ao App.
- A função do NotificationManager é ser um objeto que gerencia o disparo de notificações do App.
- A importância de estender a classe FirebaseMessagingService é ser um serviço que permite o recebimento de notificações em segundo plano, ou com o App fechado.
- Os benefícios do Content Provider é permite compartilhar dados de uma aplicação com outra de forma padronizada e para alterar algo, só é necessário a alteração no provider.
- Sobre imagens e fotos, podemos dizer que: As imagens vetorizadas possuem uma melhor definição final, independente de seu tamanho, pois utilizam vetores para a geração da imagem e que as imagens do tipo foto são formadas por "dot point" e podem perder qualidade de imagem de acordo com seu tamanho.
- A ordem correta para o desenvolvimento de um app que utiliza câmera: 1. Detectar e acessar a câmera; 2. Criar uma classe de visualização; 3. Criar um layout de visualização; 4. Configurar listeners para a captura; 5. Capturar e salvar arquivos; 6. Liberar a câmera
- Alternativa ao JobScheduler para aplicações que estão disponíveis para versões abaixo do Android Lollipop é o WorkManager e Firebase JobDispatcher.
- AsyncTasks fornece uma maneira de executar serviços em segundo plano?
- Uma PendingIntent é um tipo de Intent que descreve a ação que pode ser executada por aplicações externas como AppWidgetManager.
- O comportamento do Broadcast Receiver é Pub/Sub.
- O AlarmManager permite que você dispare intents/eventos em horários e/ou intervalos definidos.
- É uma maneira performática de agendar uma tarefa de modo que ela execute de hora em hora apenas se o aparelho estiver com o Wifi conectado, utilizar JobScheduler com as parametrizações adequadas para garantir a execução da tarefa.
- O Broadcast Receiver pode ser utilizado para acionar Services e executar tarefas mais longas.
- O responsável por renderizar os quadros de um processo no Android é o Thread principal.
- Sobre o ciclo de vida de um Service não está diretamente vinculado a UI (User Interface).

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


## Sobre as pastas e projetos

### ***PROJETO FINAL*** - ToDoList
Aplicativo de lembrete de tarefas

Tela inicial / Escolhendo data / Selecionando hora / Campos Preenchidos

![image](https://user-images.githubusercontent.com/62756757/128266219-c94ee814-c911-43fe-be26-826dd29a5d4d.png)  ![image](https://user-images.githubusercontent.com/62756757/128266326-473bc17c-ac4e-4d31-9267-61400ad30541.png)  ![image](https://user-images.githubusercontent.com/62756757/128266396-e12a397b-57de-436f-85de-a74990a7cc2b.png)  ![image](https://user-images.githubusercontent.com/62756757/128267140-aa005b68-4b2e-4afb-92ed-028e8721219b.png)




### Location_05
Projeto dedicado a utilização a mapas do google, api, geração de chave, e API do google.

Exemplo do Emulador, com a tela para teste da api, e com adição dos botões. 

![image](https://user-images.githubusercontent.com/62756757/127408408-1c8983dc-5f43-4619-9ebc-c2dc8df8614f.png)  ![image](https://user-images.githubusercontent.com/62756757/127417938-7e88f184-f386-4ba9-bd12-be8fdba3fd9f.png)

Pedindo permissão do usuário para usar a localização, com localização salva e com zoom, e com ```map.mapType=GoogleMap.MAP_TYPE_HYBRID``` e com informações da rua.

![image](https://user-images.githubusercontent.com/62756757/127419080-825b36bf-0887-4a3f-b69b-0751c943c894.png) ![image](https://user-images.githubusercontent.com/62756757/127564429-871417a5-f19e-470d-8b9e-6f44f1992317.png) ![image](https://user-images.githubusercontent.com/62756757/127587547-41e98980-0d92-447a-8fec-3061b7c208bd.png)

Modelo Pixel 4 API 30.

![image](https://user-images.githubusercontent.com/62756757/127713538-8265fb24-06b9-46a4-b11b-eda663bf7594.png) 

E após editar o código pra salvar a localização escolhida antes, útil para aplicativos como wase. 

![image](https://user-images.githubusercontent.com/62756757/127713837-b31c50d6-ce90-44c2-afd4-4fde680c6f64.png)

### FilmesFlix
Tela carregando, e tela com imagens dos filmes

 ![image](https://user-images.githubusercontent.com/62756757/127776015-9dfb0418-91e9-4e6c-b915-865307a75ddb.png)  ![image](https://user-images.githubusercontent.com/62756757/127776081-5d00b597-8102-4aaa-9524-e78aa243edef.png)

### android-bootcamp-drinkwater
Projeto que mostra quantos copos de água tomou.

![image](https://user-images.githubusercontent.com/62756757/127782810-6c2dcd9d-5797-4444-aca5-2acd9fafcaf3.png)  ![image](https://user-images.githubusercontent.com/62756757/127782833-718dba18-7155-4b41-990c-083096d7884e.png)



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
## Ciclo de Vida
Todo ciclo tem que ter um create, start, resume, pause, stop, e um destroy.  Sendo sua ordem do Ciclo de Vida na Inicialização: OnCreate - OnStart - OnResume, e para Finalizar: OnPause - OnDestroy - OnDestroy
``` kotlin
override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    
override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
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

## Arquiterura MVVM (Model-View-ViewModel)
- ***Domain***: Modelos e regras de negócios.
- ***Data***: Abstração para acessar o datasouce.
- ***Usecases***: Transmite as ações do usuário.
- ***App***: Irá conter as implementações das interfaces da camada de dados.
- A responsabilidade do ViewModel é cuidar da lógica da regra de negócio.
- A diferença entre liveData e mutableLiveData é que o mutableLiveData uma vez criado pode ter o valor alterado. Já o liveData não pode.
- Por padrão, não há uma quantidade mínima de camadas no clean architecture.
- No MVVM, a relação entre o repository e o data source é o repository irá usar o data source para acessar as fontes de dados locais e/ou web.
- Os principais benefícios de usar o Clean architecture em conjunto com o MVVM são melhorias na separação de conceitos e testabilidade do código.
- Nós usamos o repository para manipular as operações de dados.
- O que poderá ocorrer com o meu app se eu passar como argumento de uma função uma activity e mudar a orientação da minha tela da vertical para a horizontal é que o app vai apresentar um erro pois ao mudar a orientação da tela, a activity é recriada e como o view model não deveria ter conhecimento sobre activites/fragments e suas views, irá ocorrer um erro.
- Devemos utilizar o mutableLiveData para ser observado na view e assim que receber um resultado após executar uma tarefa assíncrona, atualizar os dados na tela.
- A arquitetura que a google recomenda para criar novos apps android é o MVVM.

## Collections
O Kotlin como outras linguagens, também faz uso de collections, como list, set, e map.

#### List
``` Kotlin
    val func = Funcionario("Carla", 1800.00, "PJ")
    val func1 = Funcionario("Carlos", 2000.00, "CLT")
    val func2 = Funcionario("Carmelia", 1500.00, "CLT")

    val funcinarios= listOf(func, func1, func2)

    funcinarios.forEach { println(it) }

    println("-------------------------")
    println(funcinarios.find { it.nome == "Carmelia" })

    println("-------------------------")
    funcinarios.sortedBy { it.salario }.forEach{println(it)}

    println("-------------------------")
    funcinarios.groupBy { it.tipo }.forEach{println(it)}
    
``` 

#### Set
``` Kotlin
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
```
#### Map
``` Kotlin
val pair: Pair<String, Double> = Pair("Stephan", 4500.00)
    val map1 = mapOf(pair)

    map1.forEach { (k, v) -> println("Chave: $k = Valor: $v") }

    println("--------------------------")
    val map2 = mapOf("Damon" to 5500.00, "Elena" to 7800.00)
    map2.forEach { (k, v) -> println("Chave: $k = Valor: $v") }
```
Além também, de conter as listas multáveis, aquelas que podemos alterar depois de iniciarmos.

#### MultableListOf
Adicionando
``` Kotlin
    val func = Funcionario("Carla", 1800.00, "PJ")
    val func1 = Funcionario("Carlos", 2000.00, "CLT")
    val func2 = Funcionario("Carmelia", 1500.00, "CLT")

    val funcionarios = mutableListOf(func, func1)
    funcionarios.forEach{println(it)}

    funcionarios.add(func2)
    funcionarios.forEach{println(it)} 
```
Removendo
``` Kotlin
    funcionarios.remove(func)
    funcionarios.forEach{println(it)}
```
## Exceptions no Android Studio
- Log.e(error) é uma alternativa válida para a prevenção/tratamento de exceptions na aplicação. 
- Flavors não é uma ferramenta de debug do android studio. 
- Depuração USB/USB debbuging nos permite executar o debug em um aparelho físico conectado ao computador. 
- A ferramenta de debug mais adequada para identificar uma view que não está sendo exibida é a layout inspector. 
- O comando correto para adicionar um log de erro com a tag “Error/Button” e a mensagem “erro ao clicar no botão" é Log.e( “Error/Button”,“erro ao clicar no botão"). 
- A funcionalidade "espaço de cores” do modo desenvolvedor serve para simular o que um usuário com um determinado tipo de daltonismo vê ao interagir com o sistema Android.
- A diferença entre os comandos Log.d(String, String) e Log.v(String, String) é o primeiro (Log.d) corresponde a um log de debug (depuração) e o segundo se refere a um log detalhado que exibe todas as mensagens de registro (verbose). 
- NullPointerException é uma exception comum em java pode ser prevenida em Kotlin pelo uso do null check. 
- O comando Log.w(String, String) exibe um log de aviso (warning)

## Salvar informações no Banco de Dados
- A função do onUpgrade dentro do helper é validar se se a estrutura interna do seu banco de dados está atualizado e caso não esteja atualiza-lo.
- A vantagem de usar o SQLLite para armazenar os dados no Android diferente de outras maneiras é para poder otimizar as buscas de dados de maneira mais eficiente e rápida.
- Para montar um filtro em uma tabela de carros, pela cor e placa do veículo e que retorne somente o modelo do veículo se usa: SELECT modelo FROM carros WHERE cor = $cor AND placa LIKE ‘%$placa%’
- Ao criar um Helper para fazer o gerenciamento de chamadas de banco em nosso aplicativo, a função essencial ser implementada no helper é onCrate.
- O banco de dados interno no Android serve para guardar persistir dados de maneira offline e poder consultar elas posteriormente.
- Para centralizar as chamadas de banco em um objeto e uma instancia única, a melhor maneira de se fazer isso é usar o pattern Singleton e criar uma estrutura de object no kotlin.

## Testes
- Em alguns momentos necessitamos utilizar o Robolectric para obter o contexto da nossa aplicação. Elas são executados os testes unitários utilizando o Robolectric com JVM.
- Para criação de um método para teste unitário, devemos utilizar a anotação @Test.
- A ordem correta do fluxo de desenvolvimento com TDD é Testes falhar - Testes passar - Refatorar.
- Os principais benefícios do TDD é o código será mais limpo e simples; A confiabilidade do código será maior; Favore o processo de documentação.
- O momento no desenvolvimento de software deve ser feito a criação dos testes seguindo o TDD, antes de realizar qualquer implementação de código de projeto
- O objeto mock/fake em testes serve para simular o comportamento de um objeto real.
- TDD (test driven development): refere-se a uma técnica de programação cujo principal objetivo é escrever um código funcional limpo, a partir de um teste que tenha falhado.
- Para uma boa organização do escopo de cada método de testes, seguimos uma estrutura lógica de: preparar o método com tudo que ele precisa para em seguida ser validado.
- Para conseguirmos criar e executar testes unitários, devemos criá-los em um pacote especifico no pacote Test.
- Para fazer a asserção de valores numéricos em testes unitários, utilizamos o método: assetEquals().

## Fontes
- [KotlinLang](https://play.kotlinlang.org/)
- [GoogleDeveloper](https://developers.google.com/android/play-protect/starting-a-vdp)
- [AndroidDeveloper](https://developer.android.com/studio/preview)
- [AndroidDeveloper](https://developer.android.com/security)
- [AndroidDeveloper](https://developer.android.com/platform/technology/app-bundle)
- [DigitalInnovationOne](https://web.digitalinnovation.one/track/santander-mobile-developer?tab=path)
- [GitJether](https://github.com/jether2011/digitalinnovation)
- [Kotlin](https://web.digitalinnovation.one/track/santander-mobile-developer?tab=path)
- [Bootcamp](https://drive.google.com/file/d/1vFeeoEKuyyPo2hH8_hzqGxFqI87CIVB5/view)
- [Bootcamp](https://drive.google.com/file/d/1WbVvZ9aWLhyGHebl1uodxx1YngqTweOT/view)
- [Bootcamp](https://drive.google.com/file/d/1h5H7C8eDKdW74oABhUMbBePOyRKn5cq-/view)
- [Bootcamp](https://drive.google.com/file/d/1AxY8iY361-KGAbRAYUwGHmIFJ_3R-qkZ/view)
- [Bootcamp](https://drive.google.com/file/d/1_OkuSlVclCod24bcpKcmogbUxUmkG9kQ/view)
- [Bootcamp](https://drive.google.com/file/d/1RpMwopH4AJ4mmzXHFko3hUP891uhorH9/view)
- [Bootcamp](https://raw.githubusercontent.com/natanfelipe/FilmesFlixJson/master/moviesList)
- [Bootcamp](https://github.com/natanfelipe/FilmesFlix/tree/codebase_inicial)
- [Api-Open-Notify](http://api.open-notify.org/)

## Authors 👩‍💻💖

- [@daliladilazzaro](https://github.com/daliladilazzaro)
