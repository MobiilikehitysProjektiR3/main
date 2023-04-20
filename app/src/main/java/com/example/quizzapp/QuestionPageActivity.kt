package com.example.quizzapp


import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v4.app.INotificationSideChannel
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextClock
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

//Määritellään luokka "QuestionPageActivity", joka perii toiminnallisuuden "AppCompatActivity"- ja "View.OnClickListener"-luokilta
class QuestionPageActivity  : AppCompatActivity(), View.OnClickListener {

    // Määritellään muuttujat
    private lateinit var progressBar: ProgressBar
    private lateinit var tvProgress: TextView
    private lateinit var tvQuestion: TextView
    private lateinit var tvOptionOne: TextView
    private lateinit var tvOptionTwo: TextView
    private lateinit var tvOptionThree: TextView
    private lateinit var tvOptionFour: TextView
    private lateinit var btnSubmit: Button

    // Määritellään muuttujat kyselyyn liittyville tiedoille
    private var mCurrentPosition:Int = 1
    private var mQuestionList: ArrayList<Question>? = null
    private var mSelectedOptionPosition : Int = 0
    private var mCorrectAnswers: Int = 0
    private var mUserName: String? = null

    // Luokan alustaminen
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.question_page) // Asettaa näkymän XML-tiedostosta nimeltä "question_page"

        // Haetaan aktiviteetin elementit niiden ID:llä
        progressBar = findViewById(R.id.progressBar)
        tvProgress = findViewById(R.id.tv_progress)
        tvQuestion = findViewById(R.id.tv_question)
        tvOptionOne = findViewById(R.id.tv_option_one)
        tvOptionTwo = findViewById(R.id.tv_option_two)
        tvOptionThree = findViewById(R.id.tv_option_three)
        tvOptionFour = findViewById(R.id.tv_option_four)
        btnSubmit = findViewById(R.id.btn_submit)

        mUserName = intent.getStringExtra(Questions.USER_NAME) // Haetaan käyttäjänimi Intentin avulla


        mQuestionList = Questions.getQuestions()// Haetaan kysymyslista Questions-objektilta


        setQuestion() // Asettaa ensimmäisen kysymyksen näkymään

        // Asetetaan kuuntelijat kaikille vaihtoehdoille ja "submit"-napille
        tvOptionOne.setOnClickListener(this)
        tvOptionTwo.setOnClickListener(this)
        tvOptionThree.setOnClickListener(this)
        tvOptionFour.setOnClickListener(this)
        btnSubmit.setOnClickListener(this)


    }
    private fun setQuestion(){

        val question = mQuestionList!![mCurrentPosition-1]

        // Palauta oletusnäkymä kaikille vaihtoehdoille
        defaultOptionsView()

        // Jos nykyinen kysymys on viimeinen kysymys, muuta Lähetä-painikkeen teksti "Lopeta"
        // muuten pidä se "Lähetä" -tekstinä
        if (mCurrentPosition == mQuestionList!!.size){
            btnSubmit.text = "Lopeta"
        }else{
            btnSubmit.text = "Lähetä"
        }

        // Aseta nykyinen edistyminen
        progressBar.progress = mCurrentPosition
        tvProgress.text = "$mCurrentPosition" + "/" + progressBar.max

        // Aseta kysymyksen teksti ja vaihtoehtovaihtoehdot
        tvQuestion.text = question!!.question
        tvOptionOne.text = question.optionOne
        tvOptionTwo.text = question.optionTwo
        tvOptionThree.text = question.optionThree
        tvOptionFour.text = question.optionFour
    }

    // Aseta oletusarvot vaihtoehtojen näkymille
    private fun defaultOptionsView(){

        // Luo TextView-lista, joka sisältää kaikki vaihtoehdot
        val options = ArrayList<TextView>()
        options.add(0, tvOptionOne)
        options.add(1, tvOptionTwo)
        options.add(2, tvOptionThree)
        options.add(3, tvOptionFour)

        // Muuta jokaisen vaihtoehdon tekstin väri mustaksi, fontti oletukseksi ja tausta oletusnäkymäksi
        for (option in options){
            option.setTextColor(Color.parseColor("#FF000000"))
            option.typeface = Typeface.DEFAULT
            option.background =  ContextCompat.getDrawable(this,R.drawable.default_option_border_bg)
        }
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.tv_option_one ->{
                selectedOptionView(tvOptionOne,1)
            }
            R.id.tv_option_two ->{
                selectedOptionView(tvOptionTwo,2)
            }
            R.id.tv_option_three ->{
                selectedOptionView(tvOptionThree,3)
            }
            R.id.tv_option_four ->{
                selectedOptionView(tvOptionFour,4)
            }
            R.id.btn_submit ->{
                if (mSelectedOptionPosition == 0){
                    // Siirry seuraavaan kysymykseen, jos käyttäjä ei ole valinnut vastausta
                    mCurrentPosition++

                    when{
                        // Jos kaikki kysymykset on esitetty, näytä tulos
                        mCurrentPosition <= mQuestionList!!.size ->{
                            setQuestion()
                        }else ->{
                            val intent = Intent(this, ResultActivity::class.java)
                            intent.putExtra(Questions.USER_NAME, mUserName)
                            intent.putExtra(Questions.CORRECT_ANSWERS, mCorrectAnswers)
                            intent.putExtra(Questions.TOTAL_QUESTIONS, mQuestionList!!.size)
                            startActivity(intent)
                            finish()
                        }
                    }
                }else{
                    // Jos käyttäjä on valinnut vastauksen
                    val question = mQuestionList?.get(mCurrentPosition -1)
                    if (question!!.correctAnswer != mSelectedOptionPosition){
                        // Näytä väärä vastaus punaisella reunuksella
                        answerView(mSelectedOptionPosition, R.drawable.wrong_option_border_bg)
                    }else{
                        mCorrectAnswers++
                    }
                    // Näytä oikea vastaus vihreällä reunuksella
                    answerView(question.correctAnswer, R.drawable.correct_option_border_bg)

                    if(mCurrentPosition == mQuestionList!!.size){
                        btnSubmit.text = "Lopeta"
                    }else{
                        btnSubmit.text = "Seuraava kysymys"
                    }
                    mSelectedOptionPosition = 0
                }
            }
        }
    }

    private fun answerView(answer: Int, drawableView: Int){
        // Muuttaa valitun vastausvaihtoehdon taustavärin oikeaksi tai vääräksi
        when(answer){
            1->{
                tvOptionOne.background = ContextCompat.getDrawable(this, drawableView)
            }
            2->{
                tvOptionTwo.background = ContextCompat.getDrawable(this, drawableView)
            }
            3->{
                tvOptionThree.background = ContextCompat.getDrawable(this, drawableView)
            }
            4->{
                tvOptionFour.background = ContextCompat.getDrawable(this, drawableView)
            }
        }
    }

    private fun selectedOptionView(tv: TextView, selectedOptionNum: Int){
        // Palauttaa kaikki vastausvaihtoehdot oletusarvoihin ja merkitsee valitun vaihtoehdon
        defaultOptionsView()
        mSelectedOptionPosition = selectedOptionNum

        tv.setTextColor(Color.parseColor("#FF000000"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background =  ContextCompat.getDrawable(this,R.drawable.selected_option_border_bg)
    }
}
