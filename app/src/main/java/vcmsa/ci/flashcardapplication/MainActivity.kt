package vcmsa.ci.flashcardapplication

import android.content.Intent
import android.os.Bundle
import android.os.Message
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {

    private lateinit var titleMessage: TextView
    private lateinit var welcomeMessage: TextView
    private lateinit var startBtn: Button
    private lateinit var exitBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val titleMessage: TextView = findViewById(R.id.titleMessage)
        val welcomeMessage: TextView = findViewById(R.id.welcomeMessage)
        val startBtn: Button = findViewById(R.id.startBtn)
        val exitBtn: Button = findViewById(R.id.exitBtn)

        startBtn.setOnClickListener {
            val intent = Intent(this, QuizScreen::class.java)
            startActivity(intent)
        }

        exitBtn.setOnClickListener {
         finishAffinity() //Close all activities
         exitProcess(0) //Terminate the process
        }

    }
}