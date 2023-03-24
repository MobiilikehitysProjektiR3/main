package com.example.quizzapp


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class AgeClassPageActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.age_class_page)

        val Button1: Button =findViewById(R.id.classBu1)
        Button1.setOnClickListener {
            val intent = Intent(this, FirstTopicPageActivity::class.java)
            startActivity(intent)
        }
        val Button2: Button =findViewById(R.id.classBu2)
        Button2.setOnClickListener {
            val intent = Intent(this, SecondTopicPageActivity::class.java)
            startActivity(intent)
        }
        val Button3: Button =findViewById(R.id.classBu3)
        Button3.setOnClickListener {
            val intent = Intent(this, ThirdTopicPageActivity::class.java)
            startActivity(intent)
        }

    }
}