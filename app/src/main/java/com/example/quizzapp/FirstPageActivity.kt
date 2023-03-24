package com.example.quizzapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class FirstPageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.first_page)

        val loginButton: Button =findViewById(R.id.loginButton)
        loginButton.setOnClickListener {
            val intent = Intent(this, AgeClassPageActivity::class.java)
            startActivity(intent)
        }
    }
}