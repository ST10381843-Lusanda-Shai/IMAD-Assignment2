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

    //Declaring my variables for the application UI
    private lateinit var titleMessage: TextView
    private lateinit var welcomeMessage: TextView
    private lateinit var startBtn: Button
    private lateinit var exitBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        //Initialising the values for my buttons and text views
        titleMessage = findViewById(R.id.titleMessage)
        welcomeMessage = findViewById(R.id.welcomeMessage)
        startBtn = findViewById(R.id.startBtn)
        exitBtn = findViewById(R.id.exitBtn)

        //The button which will take the user to the quiz screen
        startBtn.setOnClickListener {
            val intent = Intent(this, QuizScreen::class.java)
            startActivity(intent)
            finish()
        }

        //The button which will end the application whenever the user wants to
        exitBtn.setOnClickListener {
         finishAffinity() //Close all activities
         exitProcess(0) //Terminate the process
        }

    }
}