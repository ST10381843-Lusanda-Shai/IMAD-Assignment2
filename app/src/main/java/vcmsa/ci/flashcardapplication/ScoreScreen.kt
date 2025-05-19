package vcmsa.ci.flashcardapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import kotlin.system.exitProcess

class ScoreScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_score_screen)

       val quizScoreTextView = findViewById<TextView>(R.id.quizScoreTextView)
       val quizFeedbackTextView = findViewById<TextView>(R.id.quizFeedbackTextView)
       val reviewBtn = findViewById<Button>(R.id.reviewBtn)
       val exit2Btn = findViewById<Button>(R.id.exit2Btn)

        //This function helps display the score the user got in their quiz
        val score = intent.getIntExtra("score", 0)
        quizScoreTextView.text = "Your final score: $score/5"

        //This if and else functions shows a message to the user on how well they did on the quiz
        val feedback = if (score >= 3){
            "Great job!"
        }else{
            "Keep practicing!"
        }
        quizFeedbackTextView.text = feedback

        //Sends the user to the next screen
        reviewBtn.setOnClickListener {
            val intent = Intent(this, ReviewScreen::class.java)
            startActivity(intent)
        }

        //Exit button for the user
        exit2Btn.setOnClickListener {
            finishAffinity()
            exitProcess(0)
        }

    }
}