package vcmsa.ci.flashcardapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.system.exitProcess

class ReviewScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_review_screen)

        val reviewTextView = findViewById<TextView>(R.id.reviewTextView)
        val back2Btn = findViewById<Button>(R.id.back2Btn)
        val exit3Btn = findViewById<Button>(R.id.exit3Btn)

        val questions = intent.getStringArrayExtra("questions")
        val answers = intent.getStringArrayExtra("answers")

        //Exit button for the user
        exit3Btn.setOnClickListener {
            finishAffinity()
            exitProcess(0)
        }

        back2Btn.setOnClickListener {
            val intent = Intent(this, ScoreScreen::class.java)
            startActivity(intent)
        }

    }
}

      