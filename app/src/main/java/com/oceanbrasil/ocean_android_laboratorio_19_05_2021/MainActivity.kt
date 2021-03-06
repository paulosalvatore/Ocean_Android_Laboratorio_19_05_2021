package com.oceanbrasil.ocean_android_laboratorio_19_05_2021

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    companion object {
        const val NEW_SCREEN_REQUEST_CODE = 1
        const val EXTRA_INFO = "EXTRA_INFO"
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == NEW_SCREEN_REQUEST_CODE) {
            val tvResult = findViewById<TextView>(R.id.tvResult)

            if (resultCode == Activity.RESULT_OK) {
                tvResult.text = data?.getStringExtra(DetailsActivity.DETAILS_RESULT)
            } else if (resultCode == Activity.RESULT_CANCELED) {
                tvResult.text = getString(R.string.action_canceled)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        inicializarFormulario()

        val btSendAnotherScreen = findViewById<Button>(R.id.btSendAnotherScreen)
        val tvResult = findViewById<TextView>(R.id.tvResult)

        btSendAnotherScreen.setOnClickListener {
//            // Iniciando uma Activity com conteúdo extra
//            val newScreenIntent = Intent(this, DetailsActivity::class.java)
//
//            newScreenIntent.putExtra("EXTRA_INFO", tvResult.text.toString())
//
//            startActivity(newScreenIntent)

            // Iniciando uma Activity com conteúdo extra e que esteja aguardando um resultado
            // Lembrando que o conteúdo extra é opcional
            val newScreenIntent = Intent(this, DetailsActivity::class.java)

            newScreenIntent.putExtra(EXTRA_INFO, tvResult.text.toString())

            startActivityForResult(newScreenIntent, NEW_SCREEN_REQUEST_CODE)

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
