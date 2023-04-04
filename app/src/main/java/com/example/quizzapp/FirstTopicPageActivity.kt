package com.example.quizzapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class FirstTopicPageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.first_topic_page)

        val Button1: Button =findViewById(R.id.treesBu)
        Button1.setOnClickListener {
            val intent = Intent(this, QuestionPageActivity::class.java)
            startActivity(intent)
        }
        val Button2: Button =findViewById(R.id.animalsBu)
        Button2.setOnClickListener {
            val intent = Intent(this, QuestionPageActivity::class.java)
            startActivity(intent)
        }
        val Button3: Button =findViewById(R.id.foodBu)
        Button3.setOnClickListener {
            val intent = Intent(this, QuestionPageActivity::class.java)
            startActivity(intent)
        }
    }

}