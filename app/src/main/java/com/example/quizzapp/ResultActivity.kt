package com.example.quizzapp


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView



class ResultActivity : AppCompatActivity() {

    // Määritetään muuttujat
    private lateinit var tv_name: TextView
    private lateinit var tv_score: TextView
    private lateinit var btn_finish: Button
    private lateinit var btn_scoreboard: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        // Haetaan aktiviteetin elementit niiden ID:llä
        tv_name = findViewById(R.id.tv_name)
        tv_score = findViewById(R.id.tv_score)
        btn_finish = findViewById(R.id.btn_finish)
        btn_scoreboard = findViewById(R.id.btn_scoreboard)

        val username = intent.getStringExtra(Questions.USER_NAME)
        tv_name.text = username
        val totalQuestion = intent.getIntExtra(Questions.TOTAL_QUESTIONS, 0)
        val correctAnswers = intent.getIntExtra(Questions.CORRECT_ANSWERS, 0)

        tv_score.text = "Tuloksesi on $correctAnswers / $totalQuestion"

        // Siirrytään takaisin etusivulle
        btn_finish.setOnClickListener{
            startActivity(Intent(this, FirstPageActivity::class.java))
            finish()
        }

        //Avataan tulossivu
        btn_scoreboard.setOnClickListener{
            startActivity(Intent(this, ScoreBoardActivity::class.java))
            //val intent = Intent(this, ScoreBoardActivity::class.java).apply {
                //putExtra(username, correctAnswers)
            //}

        }

        //Lisää käyttäjänimi ja oikeat vastaukset tietokantaan
        username?.let {
            val userDatabase = UserDatabase(this)
            userDatabase.addUser(username, correctAnswers)
        }
    }
}






