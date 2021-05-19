package com.oceanbrasil.ocean_android_laboratorio_19_05_2021

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val extraInfo = intent.getStringExtra("EXTRA_INFO")

        val tvInfo = findViewById<TextView>(R.id.tvInfo)
        tvInfo.text = extraInfo
    }
}
