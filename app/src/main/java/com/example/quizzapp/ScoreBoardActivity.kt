package com.example.quizzapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.quizzapp.UserDatabase.Companion.COLUMN_CORRECT_ANSWERS
import com.example.quizzapp.UserDatabase.Companion.TABLE_NAME

class ScoreBoardActivity : AppCompatActivity() {

    private lateinit var btn_finish: Button
    private lateinit var list_view_scores: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score_board)

        btn_finish = findViewById(R.id.btn_finish_2)

        // Luetaan tietokannan tiedot
        val userList = getUserList()

        list_view_scores = findViewById(R.id.list_view_scores)
        // Luo taulukkoadapteri, joka näyttää tiedot ListView:ssa
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, userList)
        list_view_scores.adapter = adapter

        //Siirrytään takas etusivulle
        btn_finish.setOnClickListener{
            startActivity(Intent(this, FirstPageActivity::class.java))
            finish()
        }
    }

    //Haetaan tiedot tietokannasta, järjestetään ne suurimmasta pienimpään tulosten perusteella
    @SuppressLint("Range")
    private fun getUserList(): ArrayList<String> {
        val userList = ArrayList<String>()
        val selectQuery = "SELECT * FROM $TABLE_NAME ORDER BY $COLUMN_CORRECT_ANSWERS DESC"
        val db = UserDatabase(this).readableDatabase
        val cursor = db.rawQuery(selectQuery, null)

        if (cursor.moveToFirst()) {
            do {
                val username = cursor.getString(cursor.getColumnIndex(UserDatabase.COLUMN_USERNAME))
                val correctAnswers = cursor.getInt(cursor.getColumnIndex(UserDatabase.COLUMN_CORRECT_ANSWERS))
                userList.add("$username: $correctAnswers")
            } while (cursor.moveToNext())
        }

        cursor.close()
        db.close()

        return userList
    }
}

