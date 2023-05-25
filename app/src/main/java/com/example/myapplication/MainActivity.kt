package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val knopka =findViewById<View>(R.id.Play1)
        val knopka3 =findViewById<View>(R.id.Play10)
        val exitButton =findViewById<View>(R.id.Exit1)

        knopka.setOnClickListener {
        val intent = Intent(this, TiktakActivity::class.java)
        startActivity(intent)
        }
        exitButton.setOnClickListener {
            finishAffinity()
        }
        knopka3.setOnClickListener {
            val intent = Intent(this, PlayersActivity::class.java)
            startActivity(intent)
        }
    }
}

