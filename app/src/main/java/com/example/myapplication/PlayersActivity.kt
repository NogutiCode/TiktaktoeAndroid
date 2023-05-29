package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class PlayersActivity : AppCompatActivity() {
    var stepN = 0
    private lateinit var step: Array<String>
    private lateinit var exitBtn: View
    private lateinit var tok1: Button
    private lateinit var tok2: Button
    private lateinit var tok3: Button
    private lateinit var tok4: Button
    private lateinit var tok5: Button
    private lateinit var tok6: Button
    private lateinit var tok7: Button
    private lateinit var tok8: Button
    private lateinit var tok9: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_players)

        initViews()
        initListeners()
    }

    private fun initViews() {
        step = arrayOf("X", "0")
        exitBtn = findViewById<View>(R.id.exitToAboutScreen)
        tok1 = findViewById<Button>(R.id.tok1)
        tok2 = findViewById<Button>(R.id.tok2)
        tok3 = findViewById<Button>(R.id.tok3)
        tok4 = findViewById<Button>(R.id.tok4)
        tok5 = findViewById<Button>(R.id.tok5)
        tok6 = findViewById<Button>(R.id.tok6)
        tok7 = findViewById<Button>(R.id.tok7)
        tok8 = findViewById<Button>(R.id.tok8)
        tok9 = findViewById<Button>(R.id.tok9)
    }

    private fun initListeners() {
        exitBtn.setOnClickListener {
            val intent = Intent(this, AboutActivity::class.java)
            startActivity(intent)
        }

        val buttons = arrayOf(tok1, tok2, tok3, tok4, tok5, tok6, tok7, tok8, tok9)

        buttons.forEach { button ->
            button.setOnClickListener {
                if (button.text == "") {
                    button.text = step[stepN]
                    stepN = 1 - stepN
                    button.isEnabled = false
                    gameOver()
                }
            }
        }
    }

    private fun draw() {
        val buttons = arrayOf(tok1, tok2, tok3, tok4, tok5, tok6, tok7, tok8, tok9)
        val isBoardFull = buttons.all { it.text != "" }

        if (isBoardFull) {
            val intent = Intent(this, WinActivity::class.java)
            startActivity(intent)
        }
    }

    private fun winX() {
        startActivity(Intent(this, XwinActivity::class.java))
    }

    private fun winO() {
        startActivity(Intent(this, OwinActivity::class.java))
    }

    private fun gameOver() {
        val winningCombinations = arrayOf(
            arrayOf(tok1, tok2, tok3),
            arrayOf(tok4, tok5, tok6),
            arrayOf(tok7, tok8, tok9),
            arrayOf(tok1, tok4, tok7),
            arrayOf(tok3, tok6, tok9),
            arrayOf(tok1, tok5, tok9),
            arrayOf(tok3, tok5, tok7),
            arrayOf(tok2, tok5, tok8)
        )

        for (combination in winningCombinations) {
            if (combination[0].text != "" && combination[0].text == combination[1].text && combination[1].text == combination[2].text) {
                if (combination[0].text == "X") {
                    winX()
                } else if (combination[0].text == "0") {
                    winO()
                }
                return
            }
        }
        draw()
    }
}