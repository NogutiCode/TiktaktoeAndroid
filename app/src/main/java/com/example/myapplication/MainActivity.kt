package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()

    }

    private fun initViews() {
        val playVsBotBtn = findViewById<View>(R.id.playVsBotButton)
        val playVsPlayerBtn = findViewById<View>(R.id.playVsPlayerButton)
        val exitButton = findViewById<View>(R.id.exit)

        playVsBotBtn.setOnClickListener {
            startActivity(Intent(this, TiktakActivity::class.java))
        }
        playVsPlayerBtn.setOnClickListener {
            startActivity(Intent(this, PlayersActivity::class.java))
        }
        exitButton.setOnClickListener {
            finishAffinity()
        }
    }
}

