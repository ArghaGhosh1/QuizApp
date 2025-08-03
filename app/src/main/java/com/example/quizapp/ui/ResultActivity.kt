package com.example.quizapp.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.quizapp.MainActivity
import com.example.quizapp.R
import com.example.quizapp.utils.Constants

class ResultActivity : AppCompatActivity() {

    private lateinit var usernameTextView: TextView
    private lateinit var scoreTextView: TextView
    private lateinit var finishButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        usernameTextView = findViewById(R.id.usernameTextView)
        scoreTextView = findViewById(R.id.scoreTextView)
        finishButton = findViewById(R.id.finishButton)

        val username = intent.getStringExtra(Constants.USER_NAME)
        val score = intent.getIntExtra(Constants.SCORE,0)
        val totalScore = intent.getIntExtra(Constants.TOTAL_QUESTIONS,0)

        usernameTextView.text = username
        scoreTextView.text = "Your Score is $score out of $totalScore"

        finishButton.setOnClickListener {
            Intent(this@ResultActivity, MainActivity :: class.java).also{
                startActivity(it)
            }
        }
    }
}