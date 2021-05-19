# Android Laboratório

[Repositório da aula de Introdução](https://github.com/paulosalvatore/Ocean_Android_Introducao_18_05_2021)

### 1-  correção exercício da aula anterior

[Resolução na MainActivity](https://github.com/paulosalvatore/Ocean_Android_Laboratorio_19_05_2021/blob/main/app/src/main/java/com/oceanbrasil/ocean_android_laboratorio_19_05_2021/MainActivity.kt)

[Layout da MainActivity](https://github.com/paulosalvatore/Ocean_Android_Laboratorio_19_05_2021/blob/main/app/src/main/res/layout/activity_main.xml)

### 2-  Criando uma segunda activity (DetailsActivity)

* File > New > Activity > Empty Activity

### 3- Transição entre as duas telas

* Criando botão na activity_main.xml (para abrir a outra tela)

* Criando variável para o botão e adicionando OnClickListener

  `val btnSendAnotherScreen = findViewById<Button>(R.id.btnSendAnotherScreen )`

  `btnSendAnotherScreen.setOnClickListener {} `

* Criação Intent

  `val newScreenIntent = Intent(this, DetailsActivity::class.java)`

  `startActivity(newScreenIntent)`

* Código inteiro:

  ```kotlin
  val btSendAnotherScreen = findViewById<Button>(R.id.btSendAnotherScreen)
  
  btSendAnotherScreen.setOnClickListener {
  	val newScreenIntent = Intent(this, DetailsActivity::class.java)
  
  	startActivity(newScreenIntent)
  }
  ```

* Outros tipos de Intent (call, sms)

  ``` kotlin
  // SMS
  val number = "987654321"
  val intent = Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", number, null))
  startActivity(intent)
  
  // Call
  val intent = Intent(Intent.ACTION_DIAL)
  intent.data = Uri.parse("tel:987654321")
  startActivity(intent)
  ```

  

### 4- Passando informações entre Activities

#### Usando putExtra para enviar as informações (na MainActivity):

* Como é preciso mandar uma string pelo putExtra, usaremos o valor do TextView result que criamos ao resolver o exercício (tópico 1), pois ela já possui a junção de todas as informações digitadas (name, lastName, age):

  ```kotlin
  //antes
  //newScreenIntent.putExtra("EXTRA_INFO", "Texto declarado na MainActivity")
  
  //depois
  newScreenIntent.putExtra("EXTRA_INFO", tvResult.text.toString())
  ```

  

#### Usando intent para receber as informações passadas (na DetailsActivity)

```kotlin
val extraInfo = intent.getStringExtra("EXTRA_INFO")
```



### 6- Devolvendo feedbacks  para a MainActivity

#### Na DetailsActivity:

* obs: foi criado 2 botôes na DetailsActivity: OK e CANCEL

* Quando clicar no botão OK, retornaremos à MainActivity:

  ```kotlin
  btOk.setOnClickListener {
  	val resultIntent = Intent()
  	resultIntent.putExtra("DETAILS_RESULT", "Info na DetailsActivity")
  
  	setResult(Activity.RESULT_OK, resultIntent)
  
  	finish()
  }
  ```

#### Na MainActivity:

* Criar um Companion Object:

  ```kotlin
  companion object {
  	const val NEW_SCREEN_REQUEST_CODE = 1
  }
  ```

* Criar override da fun onActivityResult:

  ```kotlin
  override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
  	super.onActivityResult(requestCode, resultCode, data)
      if (requestCode == NEW_SCREEN_REQUEST_CODE) {
  		val tvResult = findViewById<TextView>(R.id.tvResult)
  
  		if (resultCode == Activity.RESULT_OK) {
  			tvResult.text = data?.getStringExtra("DETAILS_RESULT")
  		} else if (resultCode == Activity.RESULT_CANCELED) {
  			tvResult.text = "Ação cancelada."
      	}
  	}
  }
  
  ```

  