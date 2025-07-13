package ru.netology.testing.uiautomator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Когда нажата кнопка "Change Text", меняем текст в тексте View
        buttonChange.setOnClickListener {
            textToBeChanged.text = userInput.text.toString()
        }

        // Когда нажата кнопка "Open New Activity", переходим на новую активность
        buttonActivity.setOnClickListener {
            val intent = Intent(this, ru.netology.testing.uiautomator.SecondActivity::class.java)
            intent.putExtra("TEXT_KEY", userInput.text.toString()) // Передача текста в новый экран
            startActivity(intent)
        }
    }
}
