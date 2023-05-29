package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlin.system.exitProcess

class AboutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        initViews()
    }

    private fun initViews() {
        val playAgainBtn = findViewById<View>(R.id.playAgainButton)
        val exitBtn = findViewById<View>(R.id.exitFromProgram)

        playAgainBtn.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
        exitBtn.setOnClickListener {
            finishAffinity()
        }
    }
}