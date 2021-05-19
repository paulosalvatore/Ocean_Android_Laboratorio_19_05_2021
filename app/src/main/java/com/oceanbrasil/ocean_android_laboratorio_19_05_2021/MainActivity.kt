package com.oceanbrasil.ocean_android_laboratorio_19_05_2021

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        inicializarFormulario()

        val btSendAnotherScreen = findViewById<Button>(R.id.btSendAnotherScreen)

        btSendAnotherScreen.setOnClickListener {
//            val newScreenIntent = Intent(this, DetailsActivity::class.java)
//
//            startActivity(newScreenIntent)

//            // Call
//            val intent = Intent(Intent.ACTION_DIAL)
//            intent.data = Uri.parse("tel:987654321")
//            startActivity(intent)

//            // SMS
//            val number = "987654321"
//            val intent = Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", number, null))
//            startActivity(intent)
        }
    }

    private fun inicializarFormulario() {
        val etName = findViewById<EditText>(R.id.etName)
        val etLastName = findViewById<EditText>(R.id.etLastName)
        val etAge = findViewById<EditText>(R.id.etAge)
        val btSend = findViewById<Button>(R.id.btSend)
        val tvResult = findViewById<TextView>(R.id.tvResult)

        btSend.setOnClickListener {
            val name = etName.text
            val lastName = etLastName.text
            val age = etAge.text

            val isNameValid = name.isNotBlank()
            val isLastNameValid = lastName.isNotBlank()
            val isAgeValid = age.isNotBlank()

            if (!isNameValid) {
                etName.error = getString(R.string.insert_a_valid_name)
            }

            if (!isLastNameValid) {
                etLastName.error = getString(R.string.insert_a_valid_lastname)
            }

            if (!isAgeValid) {
                etAge.error = getString(R.string.insert_a_valid_age)
            }

            if (isNameValid && isLastNameValid && isAgeValid) {
                tvResult.text = getString(R.string.result_text, name, lastName, age)
            }
        }

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
