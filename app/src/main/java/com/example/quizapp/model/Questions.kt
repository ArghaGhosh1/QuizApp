package com.example.quizapp.model

data class Questions(
    val id: Int,
    val question: String,
    val image: Int,
    val optionOne: String,
    val optionTwo: String,
    val OptionThree: String,
    val optionFour: String,
    val correctAnswer: Int
)
