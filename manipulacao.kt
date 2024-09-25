fun main(args: Array<String>) {

    var nome: String = "Luiz"
    var idade: Int = 19
    var altura: Double = 1.90
    var estudante: Boolean = true

    var nome2: String = "Mateus"
    var idade2: Int = 19
    var altura2: Double = 1.70
    var estudante2: Boolean = true

    var somaIdade = idade + idade2
    var somaAltura1 = altura*2
    var somaAltura2 = altura2*2

    println("Olá $nome! Aqui estão seus dados:")
    println("Nome: $nome")
    println("Idade: $idade")
    println("Altura: $altura")
    println("Soma de idade: $somaIdade")
    println("Altura em dobro: $somaAltura1")
    println("É estudante")

    println()
    println()

    println("Olá $nome2! Aqui estão seus dados:")
    println("Nome: $nome2")
    println("Idade: $idade2")
    println("Altura: $altura2")
    println("Soma de idade: $somaIdade")
    println("Altura em dobro: $somaAltura2")
    println("É estudante")

    println()
    println()

    println("Obrigado por usar nosso sistema de cadastro, tenha um bom dia!")











}
