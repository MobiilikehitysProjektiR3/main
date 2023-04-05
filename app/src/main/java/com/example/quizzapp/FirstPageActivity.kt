package com.example.quizzapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class FirstPageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.first_page)

        val name: EditText =findViewById(R.id.et_name)

        findViewById<Button>(R.id.btn_start).setOnClickListener{

            if(name.text.toString().isEmpty()){
                Toast.makeText(this, "Syötä käyttäjänimesi", Toast.LENGTH_SHORT).show()
            }else{
                val intent = Intent(this,QuestionPageActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }
}
