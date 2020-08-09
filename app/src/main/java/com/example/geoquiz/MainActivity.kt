package com.example.geoquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import com.example.geoquiz.R.id.question_text_view

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {

    private lateinit var trueButton: Button
    private lateinit var falseButton: Button
    private lateinit var nextButton: ImageButton
    private lateinit var previousButton: ImageButton
    private lateinit var questionTextView: TextView

    private val questionBank = listOf(
        Question(R.string.question_america,true),
        Question(R.string.question_cambodia,false),
        Question(R.string.question_japan,false),
        Question(R.string.question_norway,true)
    )

    private var currentIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG2, "onCreate: stuff")
        setContentView(R.layout.activity_main)

        trueButton = findViewById(R.id.true_button)
        falseButton = findViewById(R.id.false_button)
        nextButton = findViewById(R.id.next_button)
        previousButton = findViewById(R.id.previous_button)
        questionTextView = findViewById(question_text_view)

        trueButton.setOnClickListener { view: View? ->
            checkAnswer(true)
        }

        falseButton.setOnClickListener { view: View? ->
            checkAnswer(false)
        }

        questionTextView.setOnClickListener { view: View? ->
            if (currentIndex < questionBank.lastIndex) {
                currentIndex = (currentIndex + 1) % questionBank.size
                isAnswered(currentIndex)
                updateQuestion()
            }
        }

        nextButton.setOnClickListener { view: View? ->
            if (currentIndex < questionBank.lastIndex) {
                currentIndex = (currentIndex + 1) % questionBank.size
                isAnswered(currentIndex)
                updateQuestion()
            }
        }

        previousButton.setOnClickListener { view: View? ->
            if (currentIndex > 0) {
                currentIndex = (currentIndex - 1) % questionBank.size
                isAnswered(currentIndex)
                updateQuestion()
            }
        }
        updateQuestion()
    }

    override fun onStart() {
        super.onStart()
        val china = ChinaDynasty()
        Log.d(TAG, "onStart: " +china.getWarlordInfo())
    }

    override fun onResume() {
        Log.d(TAG, "onResume: called")
        super.onResume()
    }

    override fun onStop() {
        Log.d(TAG, "onStop: called")
        super.onStop()
    }

    override fun onDestroy() {
        Log.d(TAG, "onDestroy: called")
        super.onDestroy()
    }

    private fun updateQuestion() {
        val questionTextResId = questionBank[currentIndex].textResId
        questionTextView.setText(questionTextResId)
    }

    private fun checkAnswer(userAnswer:Boolean) {
        val correctAnswer = questionBank[currentIndex].answer

        val messageResId = if(userAnswer == correctAnswer) {
            R.string.correct_toast
        } else{
            R.string.incorrect_toast
        }

        trueButton.isEnabled = false
        falseButton.isEnabled = false
        questionBank[currentIndex].answered = true
        val toast = Toast.makeText(this,messageResId,Toast.LENGTH_SHORT)
        toast.setGravity(Gravity.TOP,0,150)
        toast.show()
    }

    // Challenge: Preventing Repeat Answers
    private fun isAnswered(index: Int) {
        val isQuestionAnswered = questionBank[index].answered
        trueButton.isEnabled = !isQuestionAnswered
        falseButton.isEnabled = !isQuestionAnswered
    }

    companion object {
        // private const val cannot be called as a class instance so the variable must be either
        // top level code or an object
        private const val TAG2 = "MainActivity"
    }
}