package com.oceanbrasil.ocean_android_laboratorio_19_05_2021

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*
         * Correção do Desafio:
         * Construir uma tela com três EditText: Nome, Sobrenome e Idade
         * Um TextView para o Resultado
         * Um Botão para Enviar
         *
         * Quando o usuário clicar no botão, validar se todos os dados foram digitados
         * e construir uma string no TextView do Resultado: "Olá, Paulo Salvatore, você tem 27 anos!"
         * Sendo que "Paulo" deve ser preenchido com o valor do EditText e assim por diante.
         *
         * Ao clicar no botão Enviar, você deve adicionar uma mensagem de erro em todos os EditTexts
         * que não passaram da validação.
         *
         * Além disso, o app deve estar com idioma padrão em inglês e traduzido para o português.
         */
    }
}
