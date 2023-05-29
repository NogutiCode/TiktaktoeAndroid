package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class OwinActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_owin)

        initViews()

    }

    private fun initViews(){
        val playAgainBtn = findViewById<View>(R.id.playAgainButton)
        val exitBtn = findViewById<View>(R.id.exitToAboutScreen)

        exitBtn.setOnClickListener {
            startActivity(Intent(this, AboutActivity::class.java))
        }
        playAgainBtn.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}