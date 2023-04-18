package com.example.quizzapp

object Questions {
    const val USER_NAME: String = "user_name"
    const val TOTAL_QUESTIONS: String = "total_questions"
    const val CORRECT_ANSWERS: String = "correct_answers"

    fun getQuestions(): ArrayList<Question> {
        val questionsList = ArrayList<Question>()

        // 1
        val que1 = Question(
            1, "Suomen naapurimaa ei ole",
            "Kiina", "Ruotsi",
            "Venäjä", "Norja", 1
        )

        questionsList.add(que1)

        // 2
        val que2 = Question(
            2, "Mikä on suurin maa pinta-alaltaan?",
            "Japani", "Venäjä",
            "Kanada", "Italia", 2
        )

        questionsList.add(que2)

        // 3
        val que3 = Question(
            3, "Mitä maata kutsutaan tuhansien järvien maaksi?",
            "Suomi", "Australia",
            "Norja", "Turkki", 1
        )

        questionsList.add(que3)

        // 4
        val que4 = Question(
            4, "Mikä on Suomen kansalliskukka?",
            "Ruusu", "Voikukka",
            "Orvokki", "Kielo", 4
        )

        questionsList.add(que4)

        // 5
        val que5 = Question(
            5, "Mikä on Suomen suurin petoeläin?",
            "Hirvi", "Ilves",
            "Karhu", "Susi", 3
        )

        questionsList.add(que5)

        // 6
        val que6 = Question(
            6, "Mikä on Suomen nopein eläin?",
            "Muuttohaukka", "Kauris",
            "Ilves", "Jänis", 1
        )

        questionsList.add(que6)

        // 7
        val que7 = Question(
            7, "Mikä on maailman puhutuin kieli?",
            "Englanti", "Espanja",
            "Kiina", "Norja", 3
        )

        questionsList.add(que7)

        // 8
        val que8 = Question(
            8, "Mikä on Suomen pohjoisin kaupunki?",
            "Kemijärvi", "Vantaa",
            "Jyväskylä", "Rovaniemi", 1
        )

        questionsList.add(que8)

        // 9
        val que9 = Question(
            9, "Mikä on maailman väkirikkain maa?",
            "Ruotsi", "Englanti",
            "Brazilia", "Kiina", 4
        )

        questionsList.add(que9)

        // 10
        val que10 = Question(
            10, "Mikä on Suomen kansalliskala?",
            "Ahven", "Hauki",
            "Lohi", "Siika", 1
        )

        questionsList.add(que10)


        return questionsList
    }
}