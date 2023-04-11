package com.example.quizzapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView

class ResultActivity : AppCompatActivity() {

    private lateinit var tv_name: TextView
    private lateinit var tv_score: TextView
    private lateinit var btn_finish: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        tv_name = findViewById(R.id.tv_name)
        tv_score = findViewById(R.id.tv_score)
        btn_finish = findViewById(R.id.btn_finish)

        val username = intent.getStringExtra(Questions.USER_NAME)
        tv_name.text = username
        val totalQuestion = intent.getIntExtra(Questions.TOTAL_QUESTIONS, 0)
        val correctAnswers = intent.getIntExtra(Questions.CORRECT_ANSWERS, 0)

        tv_score.text = "Tuloksesi on $correctAnswers / $totalQuestion"

        btn_finish.setOnClickListener{
            startActivity(Intent(this, FirstPageActivity::class.java))
            finish()
        }


    }
}