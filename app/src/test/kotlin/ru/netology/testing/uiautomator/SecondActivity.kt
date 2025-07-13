package ru.netology.testing.uiautomator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        // Получаем текст из намерения (Intent)
        val receivedText = intent.getStringExtra("TEXT_KEY")
        if (!receivedText.isNullOrBlank()) {
            textView.text = receivedText
        }
    }
}