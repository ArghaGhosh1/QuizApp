package com.example.quizapp.utils

import com.example.quizapp.R
import com.example.quizapp.model.Questions

object Constants {

    const val USER_NAME = "user_name"
    const val TOTAL_QUESTIONS = "total_questions"
    const val SCORE = "score"

    fun getQuestion(): MutableList<Questions>{

        val questions = mutableListOf<Questions>()

        val ques1 = Questions(
            1,"What country does this flag belong to?",
            R.drawable.comoros,"Kyrgystan","Comoros",
            "Nepal","Brunei",2
        )
        questions.add(ques1)

        val ques2 = Questions(
            2,"What country does this flag belong to?",
            R.drawable.india,"India","Comoros",
            "Laos","Sri Lanka",1
        )
        questions.add(ques2)

        val ques3 = Questions(
            3,"What country does this flag belong to?",
            R.drawable.urugua,"Nauru","Liberia",
            "Nepal","Uruguay",4
        )
        questions.add(ques3)

        val ques4 = Questions(
            4,"What country does this flag belong to?",
            R.drawable.tuvalu,"Albania","Tuvalu",
            "Dominica","Sri Lanka",2
        )
        questions.add(ques4)

        val ques5 = Questions(
            5,"What country does this flag belong to?",
            R.drawable.laos,"India","San Marino",
            "Laos","Tonga",3
        )
        questions.add(ques5)

        val ques6 = Questions(
            6,"What country does this flag belong to?",
            R.drawable.argentina,"Argentina","Liberia",
            "Nepal","Nauru",1
        )
        questions.add(ques6)

        val ques7 = Questions(
            7,"What country does this flag belong to?",
            R.drawable.oman,"Kribati","Comoros",
            "Tuvulu","Oman",4
        )
        questions.add(ques7)

        val ques8 = Questions(
            8,"What country does this flag belong to?",
            R.drawable.bang,"India","Lesotho",
            "Bangladesh","Sri Lanka",3
        )
        questions.add(ques8)

        val ques9 = Questions(
            9,"What country does this flag belong to?",
            R.drawable.bhutan,"Bhutan","Liechtenstein",
            "Nepal","Sri Lanka",1
        )
        questions.add(ques9)

        val ques10 = Questions(
            10,"What country does this flag belong to?",
            R.drawable.georgia,"Liechtenstein","Georgia",
            "Brunei","Mauritania",2
        )
        questions.add(ques10)
        return questions
    }

}