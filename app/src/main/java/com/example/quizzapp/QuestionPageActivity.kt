package com.example.quizzapp

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class QuestionPageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.question_page)


        data class Question(
            val question: String,
            val optionOne: String,
            val optionTwo: String,
            val correctAnswer: Int,
            val index: Int
        )


        val questionList = arrayListOf(
            Question("Puut eivät pudota lehtiään?", "Totta", "Tarua", 0, 0),
            Question("Palmuja kasvaa Suomessa?", "Totta", "Tarua", 1, 1),
            Question("Puiden lehdet ovat vihreitä kesäisin?", "Totta", "Tarua", 1, 2)
        )


        val questionText = findViewById<TextView>(R.id.questionView)
        val option1 = findViewById<Button>(R.id.answerBu1)
        val option2 = findViewById<Button>(R.id.answerBu2)

        val question = questionList[0]
            questionText.text = question.question
            option1.text = question.optionOne
            option2.text = question.optionTwo
    }
}
  /*
  class Question(val question: String, val options: List<String>, val answerIndex: Int) {

        val animalQu1 = Question("Puut eivät pudota lehtiään?", listOf("Totta", "Tarua"), 1)

        val animalQu2 = Question("Palmuja kasvaa Suomessa?", listOf("Totta", "Tarua"), 1)

        val animalQu3 = Question("Puiden lehdet ovat vihreitä kesäisin?", listOf("Totta", "Tarua"), 0)

        val animalQu4 = Question("Suomen yleisin puu on mänty?", listOf("Totta", "Tarua"), 0)

        val animalQu5 = Question("Kuusissa kasvaa lehdet?", listOf("Totta", "Tarua"), 1)
    }*/
  /*data class Question(
      val question: String,
      val options: List<String>,
      val correctAnswer: Int,
      val index: Int
  )
  Question("Puiden lehdet ovat vihreitä kesäisin?", listOf("Totta", "Tarua"), 1, 2)
*/
