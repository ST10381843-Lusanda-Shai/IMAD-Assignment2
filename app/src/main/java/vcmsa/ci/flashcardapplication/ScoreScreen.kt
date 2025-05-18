package vcmsa.ci.flashcardapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import kotlin.system.exitProcess

class ScoreScreen : AppCompatActivity() {

    private lateinit var next1Btn: Button
    private lateinit var exit2Btn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_score_screen)

        next1Btn = findViewById(R.id.next1Btn)
        exit2Btn = findViewById(R.id.exit2Btn)

        next1Btn.setOnClickListener {

        }

        exit2Btn.setOnClickListener {
            finishAffinity()
            exitProcess(0)
        }

    }
}