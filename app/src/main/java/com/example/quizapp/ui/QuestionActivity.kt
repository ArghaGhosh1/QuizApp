package com.example.quizapp.ui

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.quizapp.R
import com.example.quizapp.model.Questions
import com.example.quizapp.utils.Constants

class QuestionActivity : AppCompatActivity() , View.OnClickListener {

    private lateinit var questionText: TextView
    private lateinit var ImageView : ImageView
    private lateinit var progressBar : ProgressBar
    private lateinit var progressText : TextView
    private lateinit var questionList: MutableList<Questions>
    private lateinit var checkButton: Button
    private var questionCounter = 0

    private var selectedAnswer = 0
    private var score = 0
    private lateinit var name:String
    private lateinit var currentQuestion: Questions
    private var answered =false
    private lateinit var optionOne: TextView
    private lateinit var optionTwo: TextView
    private lateinit var optionThree: TextView
    private lateinit var optionFour: TextView


    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_question)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        questionText = findViewById(R.id.text_view_question)
        ImageView = findViewById(R.id.image_view)
        progressBar = findViewById(R.id.progress_Bar)
        progressText = findViewById(R.id.progress_textView)
        checkButton = findViewById(R.id.button_check)

        optionOne = findViewById(R.id.text_view_option_one)
        optionTwo = findViewById(R.id.text_view_option_two)
        optionThree = findViewById(R.id.text_view_option_three)
        optionFour = findViewById(R.id.text_view_option_four)


        optionOne.setOnClickListener(this)
        optionTwo.setOnClickListener(this)
        optionThree.setOnClickListener(this)
        optionFour.setOnClickListener(this)
        checkButton.setOnClickListener(this)

        questionList = Constants.getQuestion()

        if(intent.hasExtra(Constants.USER_NAME)){
            name = intent.getStringExtra(Constants.USER_NAME).toString()
        }

        showNextQuestion()
    }

    fun showNextQuestion()
    {
        //check if we are in the last question
        if(questionCounter < questionList.size)
        {
            checkButton.text = "CHECK"
            currentQuestion = questionList[questionCounter]

            val questions = questionList[questionCounter]
            questionText.text = questions.question
            ImageView.setImageResource(questions.image)
            progressBar.progress = questionCounter
            progressText.text = "${questionCounter+1}/${progressBar.max}"
            optionOne.text = questions.optionOne
            optionTwo.text = questions.optionTwo
            optionThree.text = questions.OptionThree
            optionFour.text = questions.optionFour
        }
        else
        {
            checkButton.text = "FINISH"
            //Start Activity
            Intent(this@QuestionActivity, ResultActivity :: class.java).also{
                it.putExtra(Constants.USER_NAME , name)
                it.putExtra(Constants.SCORE, score)
                it.putExtra(Constants.TOTAL_QUESTIONS, questionList.size)
                startActivity(it)
            }
        }

        questionCounter++
        answered = false

    }

    //reset the border of the option in next question
    private fun resetOptionBorder(){
        val options = mutableListOf<TextView>()

        options.add(optionOne)
        options.add(optionTwo)
        options.add(optionThree)
        options.add(optionFour)

        for(option in options){
            option.setTextColor(Color.GRAY)
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this, R.drawable.option_bg)
        }
    }

    //selected option background color
    private fun selectedOption(textView : TextView,selectOptionNumber : Int){
        resetOptionBorder()
        selectedAnswer = selectOptionNumber

        textView.setTextColor(Color.BLACK)
        textView.setTypeface(textView.typeface, Typeface.BOLD)
        textView.background = ContextCompat.getDrawable(this, R.drawable.select_border)
    }

    override fun onClick(view: View?)
    {
        when(view?.id){
            R.id.text_view_option_one ->{
                selectedOption(optionOne,1)
            }
            R.id.text_view_option_two -> {
                selectedOption(optionTwo,2)
            }
            R.id.text_view_option_three -> {
                selectedOption(optionThree,3)
            }
            R.id.text_view_option_four ->{
                selectedOption(optionFour,4)
            }
            R.id.button_check ->{
                if(!answered){
                    checkAnswer()
                }else{
                    showNextQuestion()
                    resetOptionBorder()
                }
                selectedAnswer = 0
            }
        }
    }

    private fun checkAnswer(){
        answered = true


        if(selectedAnswer == currentQuestion.correctAnswer){

            score++
            highlightFuntion(selectedAnswer)
        }
        else{
            when(selectedAnswer)
            {
                1 -> {
                    optionOne.background = ContextCompat.getDrawable(this,R.drawable.worng_ans)
                }
                2 -> {
                    optionTwo.background = ContextCompat.getDrawable(this,R.drawable.worng_ans)
                }
                3 -> {
                    optionThree.background = ContextCompat.getDrawable(this,R.drawable.worng_ans)
                }
                4 -> {
                    optionFour.background = ContextCompat.getDrawable(this,R.drawable.worng_ans)
                }
            }
        }

        checkButton.text = "NEXT"
        showSolution()
    }

    private fun showSolution(){
        selectedAnswer = currentQuestion.correctAnswer

        highlightFuntion(selectedAnswer)
    }
    private fun highlightFuntion(answer: Int){
        when(answer)
        {
            1 -> {
                optionOne.background = ContextCompat.getDrawable(this,R.drawable.right_ans)
            }
            2 -> {
                optionTwo.background = ContextCompat.getDrawable(this,R.drawable.right_ans)
            }
            3 -> {
                optionThree.background = ContextCompat.getDrawable(this,R.drawable.right_ans)
            }
            4 -> {
                optionFour.background = ContextCompat.getDrawable(this,R.drawable.right_ans)
            }
        }
    }
}