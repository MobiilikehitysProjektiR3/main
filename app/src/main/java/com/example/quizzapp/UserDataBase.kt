package com.example.quizzapp

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

//Luodaan tietokanta
class UserDatabase(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    companion object {
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "user_db"

        const val TABLE_NAME = "user"
        const val COLUMN_USERNAME = "username"
        const val COLUMN_CORRECT_ANSWERS = "correct_answers"
    }

    //Luodaan taulu
    override fun onCreate(db: SQLiteDatabase) {
        val CREATE_TABLE = ("CREATE TABLE " + TABLE_NAME + "("
                + COLUMN_USERNAME + " TEXT,"
                + COLUMN_CORRECT_ANSWERS + " INTEGER"
                + ")")
        db.execSQL(CREATE_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME)
        onCreate(db)
    }

    //Lisätään käyttäjä, tallennetaan username sisältö taulukon COLUMN_USERNAME kohtaan ja correctAnswer COLUMN_CORRECT_ANSWERS kohtaan
    fun addUser(username: String, correctAnswers: Int) {
        val values = ContentValues()
        values.put(COLUMN_USERNAME, username)
        values.put(COLUMN_CORRECT_ANSWERS, correctAnswers)

        val db = this.writableDatabase
        db.insert(TABLE_NAME, null, values)
        db.close()
    }

}
