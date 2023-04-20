package com.example.quizzapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

// Määritellään luokka "FirstPageActivity", joka perii toiminnallisuuden "AppCompatActivity"-luokalta
class FirstPageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.first_page)

        // Hakee käyttäjän syöttämän nimen EditText-kentästä
        val name: EditText =findViewById(R.id.et_name)

        // Määritellään toiminta "btn_start"-painiketta painettaessa
        findViewById<Button>(R.id.btn_start).setOnClickListener{

            // Tarkistetaan, onko käyttäjänimi tyhjä
            if(name.text.toString().isEmpty()){
                Toast.makeText(this, "Syötä käyttäjänimesi", Toast.LENGTH_SHORT).show()
            }else{

                // Jos käyttäjänimi on syötetty, luodaan uusi Intent-olio ja siirrytään toiseen aktiviteettiin "QuestionPageActivity"
                val intent = Intent(this,QuestionPageActivity::class.java)
                intent.putExtra(Questions.USER_NAME,name.text.toString()) // Lähetetään käyttäjänimi tietona toiseen aktiviteettiin
                startActivity(intent)// Aloittaa uuden aktiviteetin
                finish() // Lopettaa nykyisen aktiviteetin
            }
        }
    }
}
