package com.example.quizzapp

object Questions {
    const val USER_NAME: String = "user_name"
    const val TOTAL_QUESTIONS: String = "total_questions"
    const val CORRECT_ANSWERS: String = "correct_answers"

    // Määritetään kysymykset
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
            2, "Mikä on suurin maanosa?",
            "Afrikka", "Venäjä",
            "Australia", "Aasia", 4
        )

        questionsList.add(que2)

        // 3
        val que3 = Question(
            3, "Mikä on Tanskan pääkaupunki?",
            "Kööpenhamina", "Amsterdam",
            "Bryssel", "Göteborg", 1
        )

        questionsList.add(que3)

        // 4
        val que4 = Question(
            4, "Mikä seuraavista on suurin varislintu?",
            "Varis", "Naakka",
            "Korppi", "Harakka", 3
        )

        questionsList.add(que4)

        // 5
        val que5 = Question(
            5, "Mikä seuraavista väittämistä pitää paikkaansa?",
            "Jätteiden lajittelu kuormittaa ympäristöä", "Lajitteluhattu auttaa oikean roska-astian löytymisessä",
            "Lajittelun ansiosta raaka-aineita voidaan hyödyntää uusien tuotteiden materiaaliksi", "Biojätteiden lajittelulla ei tuoteta energiaa", 3
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
            8, "Millä toisella nimellä koivusokeri tunnetaan?",
            "Sorbitoli", "Sakariini",
            "Ksylitoli", "Fariini", 3
        )

        questionsList.add(que8)

        // 9
        val que9 = Question(
            9, "Mikä näistä on ajoneuvoissakin käytettävä, uusiutuva energianlähde?",
            "Fossiilinen polttoaine", "Bensiini",
            "Biokaasu", "Dieselöljy", 3
        )

        questionsList.add(que9)

        // 10
        val que10 = Question(
            10, "Kuinka ahkerasti Suomessa kierrätetään metalliromua?",
            "n.90% metallista päätyy takaisin kiertoon", "n.80% metallista päätyy takaisin kiertoon",
            "n.70% metallista päätyy takaisin kiertoon", "n.60% metallista päätyy takaisin kiertoon", 1
        )

        questionsList.add(que10)

        // 11
        val que11 = Question(
            11, "Mihin kierrätysastiaan käytöstä poistettu magneetti kuuluu?",
            "Sekajäte", "Metallinkeräys",
            "Vaarallinen jäte", "Tekstiilikeräys", 2
        )

        questionsList.add(que11)

        // 12
        val que12 = Question(
            12, "Mikä on maailman merien syvin kohta?",
            "Kurillien hauta", "Filippiinien hauta",
            "Puerto Ricon hauta", "Mariaanien hauta", 4
        )

        questionsList.add(que12)

        // 13
        val que13 = Question(
            13, "Mikä on kuivin alue maailmassa?",
            "Sahara, Pohjois-Afrikka", "Gobi, Kiina ja Mongolia",
            "Kalaharin aavikko, ", "Atacama, Etelä-Amerikka", 4
        )

        questionsList.add(que13)

        // 14
        val que14 = Question(
            14, "Missä sijaitsee maailman suurin tulivuori?",
            "Islanti", "Italia",
            "Havaji", "Indonesia", 3
        )

        questionsList.add(que14)

        // 15
        val que15 = Question(
            15, "Mikä puulaji elää Lapissa vaivaisena?",
            "Koivu", "Mänty",
            "Haapa", "Kuusi", 1
        )

        questionsList.add(que15)


        return questionsList
    }
}