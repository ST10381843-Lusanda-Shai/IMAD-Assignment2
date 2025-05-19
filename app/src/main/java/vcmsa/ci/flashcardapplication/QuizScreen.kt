package vcmsa.ci.flashcardapplication

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import kotlin.system.exitProcess

class QuizScreen : AppCompatActivity() {

    //Declaring my variables for the application UI
    private lateinit var questionTextView: TextView
    private lateinit var feedbackTextView: TextView
    private lateinit var trueBtn: Button
    private lateinit var falseBtn: Button
    private lateinit var nextBtn: Button
    private lateinit var scoreBtn: Button

    //Declaring the arrays for the questions and answers
   private val questions = arrayOf(
        "Is the earth flat",
        "Ferrari is an Italian car manufacturer",
        "Drinking water is unhealthy for you",
        "Lionel Messi is Spanish",
        "Going to the gym is will improve your physical physic",
    )

    //The variables that show the correct answers for the questions
    private val answers = arrayOf(false, true, false, false, true)

    //
    private var currentQuestionInfo = 0
    private var score = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_quiz_screen)

        //Initialising the values for my buttons and text views
        questionTextView = findViewById(R.id.questionTextView)
        feedbackTextView = findViewById(R.id.feedbackTextView)
        trueBtn = findViewById(R.id.trueBtn)
        falseBtn = findViewById(R.id.falseBtn)
        nextBtn = findViewById(R.id.nextBtn)
        scoreBtn = findViewById(R.id.scoreBtn)

        displayQuestion()

        //Pressing the button will indicate that you think the question is true
        trueBtn.setOnClickListener {
            checkAnswer(true)
        }

        //Pressing the button will indicate that you think the question is false
        falseBtn.setOnClickListener {
            checkAnswer(false)
        }

        //THe button allows the user to go to the next question after giving their answer
        nextBtn.setOnClickListener {
            currentQuestionInfo++
            if (currentQuestionInfo < questions.size){
                displayQuestion()
                feedbackTextView.text = ""
                trueBtn.isEnabled = true
                falseBtn.isEnabled = true
            }else{
                feedbackTextView.text = "You finished the quiz, well done. Final score: $score"
                nextBtn.isEnabled = false
            }
        }

        //This will take the user to the score screen
        scoreBtn.setOnClickListener {
            val intent = Intent(this, ScoreScreen::class.java)
            intent.putExtra("score", score)
            startActivity(intent)
        }
    }

    //The function which displays the questions to the user
    private fun displayQuestion(){
        questionTextView.text = questions[currentQuestionInfo]
    }

    //This allows the user will receive feedback on whether the question they answered is correct or incorrect
    private fun checkAnswer(userAnswer: Boolean){
        val correctAnswer = answers[currentQuestionInfo]
        if (userAnswer == correctAnswer){
            feedbackTextView.text = "Correct!"
            feedbackTextView.setTextColor(Color.GREEN)
            score++
        }else{
            feedbackTextView.text = "Incorrect!"
            feedbackTextView.setTextColor(Color.RED)
        }
    }

}