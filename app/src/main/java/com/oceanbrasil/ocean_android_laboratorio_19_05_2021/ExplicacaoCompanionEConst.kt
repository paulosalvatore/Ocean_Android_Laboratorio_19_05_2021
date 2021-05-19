package com.oceanbrasil.ocean_android_laboratorio_19_05_2021

// Classe -> Abstrato -> Receita
class Pessoa(val nome: String, val sobrenome: String) {
    fun exibirNomeCompleto() {
        println("$nome $sobrenome")
    }
}

// Objeto -> Concreto -> Receita construída
val paulo = Pessoa("Paulo", "Salvatore")
val angelica = Pessoa("Angelica", "dos Santos")

fun testandoClassePessoa() {
    // Essa função depende de uma receita construída, ou seja,
    // depende de um objeto
    paulo.exibirNomeCompleto()
    angelica.exibirNomeCompleto()
}

class GerenciadorPessoas(val nome: String) {
    companion object {
        fun gerenciar(pessoaParaSerGerenciada: Pessoa) {
            println("Gerenciar essa pessoa.")
        }
    }

    fun exibirNomeDoGerenciador() {
        println(nome)
    }
}

object GerenciadorPessoasNovo {
    fun gerenciar(pessoaParaSerGerenciada: Pessoa) {
        println("Gerenciar essa pessoa.")
    }
}

fun testandoGerenciadorDePessoas() {
    GerenciadorPessoas.gerenciar(paulo)
    GerenciadorPessoas.gerenciar(angelica)

    val meuGerenciador = GerenciadorPessoas("Gerenciador de Testes")
    meuGerenciador.exibirNomeDoGerenciador()

    val meuGerenciador2 = GerenciadorPessoas("Gerenciador de Produção")
    meuGerenciador2.exibirNomeDoGerenciador()

    GerenciadorPessoasNovo.gerenciar(paulo)
    GerenciadorPessoasNovo.gerenciar(angelica)
}
