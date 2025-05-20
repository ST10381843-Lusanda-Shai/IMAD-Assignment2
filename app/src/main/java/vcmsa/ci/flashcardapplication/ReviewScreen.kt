package vcmsa.ci.flashcardapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import kotlin.system.exitProcess

class ReviewScreen : AppCompatActivity() {

    // Code Attribution
    // This method was taken from
    //https://chatgpt.com/?model=auto-
    //Artificial Intelligence: ChatGPT

    data class Question(
        val questionText: String,
        val answersText: String
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_review_screen)

        //Initialising the values for my buttons and text views
        val reviewTextView = findViewById<TextView>(R.id.reviewTextView)
        val back2Btn = findViewById<Button>(R.id.back2Btn)
        val exit3Btn = findViewById<Button>(R.id.exit3Btn)

        //The functions which stores the list of questions that will be displayed
        val questionList = listOf(
            Question("Is the earth flat", "Incorrect!"),
            Question("Ferrari is an Italian car manufacturer", "Correct!"),
            Question("Drinking water is unhealthy for you", "Incorrect!"),
            Question("Lionel Messi is Spanish", "Incorrect!"),
            Question("Going to the gym is will improve your physical physic", "Correct!")
        )

        val stringBuilder = StringBuilder()

        //This is a function that add my questions and answers to an added list
        questionList.forEachIndexed { index, question -> stringBuilder.append("${index + 1}.${question.questionText}\n")
            stringBuilder.append("Answer: ${question.answersText}\n\n")
        }

        reviewTextView.text = stringBuilder.toString()

        //Exit button for the user
        exit3Btn.setOnClickListener {
            finishAffinity()
            exitProcess(0)
        }

        //Back button for the user
        back2Btn.setOnClickListener {
            val intent = Intent(this, QuizScreen::class.java)
            startActivity(intent)
        }

    }
}

      