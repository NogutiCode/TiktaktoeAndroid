package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class PlayersActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_players)

        var step = arrayOf("X", "0")
        var stepN = 0

        val knopka = findViewById<View>(R.id.Exit10)
        val tok1 = findViewById<Button>(R.id.tok1)
        val tok2 = findViewById<Button>(R.id.tok2)
        val tok3 = findViewById<Button>(R.id.tok3)
        val tok4 = findViewById<Button>(R.id.tok4)
        val tok5 = findViewById<Button>(R.id.tok5)
        val tok6 = findViewById<Button>(R.id.tok6)
        val tok7 = findViewById<Button>(R.id.tok7)
        val tok8 = findViewById<Button>(R.id.tok8)
        val tok9 = findViewById<Button>(R.id.tok9)


        knopka.setOnClickListener {
            val intent = Intent(this, AboutActivity::class.java)
            startActivity(intent)
        }

        fun draw() {
            if (tok1.text !== "" && tok2.text !== "" && tok3.text !== "" && tok4.text !== "" &&
                tok5.text !== "" && tok6.text !== "" && tok7.text !== "" && tok8.text !== "" &&
                tok9.text !== ""
            ) {

                val intent = Intent(this, WinActivity::class.java)
                startActivity(intent)
            }
        }

        fun winX() {
            val intent = Intent(this, XwinActivity::class.java)
            startActivity(intent)
        }

        fun winO() {
            val intent = Intent(this, OwinActivity::class.java)
            startActivity(intent)
        }

        fun gameOver() {
            if (tok1.text !== "" && tok1.text == tok2.text && tok2.text == tok3.text) {
                if (tok1.text == "X") {
                    winX()
                } else if (tok1.text == "0") {
                    winO()
                }
            } else if (tok4.text !== "" && tok4.text == tok5.text && tok5.text == tok6.text) {
                if (tok4.text == "X") {
                    winX()
                } else if (tok4.text == "0") {
                    winO()
                }
            } else if (tok7.text !== "" && tok7.text == tok8.text && tok8.text == tok9.text) {
                if (tok7.text == "X") {
                    winX()
                } else if (tok7.text == "0") {
                    winO()
                }
            } else if (tok1.text !== "" && tok1.text == tok4.text && tok4.text == tok7.text) {
                if (tok1.text == "X") {
                    winX()
                } else if (tok1.text == "0") {
                    winO()
                }
            } else if (tok3.text !== "" && tok3.text == tok6.text && tok6.text == tok9.text) {
                if (tok3.text == "X") {
                    winX()
                } else if (tok3.text == "0") {
                    winO()
                }
            } else if (tok1.text !== "" && tok1.text == tok5.text && tok5.text == tok9.text) {
                if (tok1.text == "X") {
                    winX()
                } else if (tok1.text == "0") {
                    winO()
                }
            } else if (tok3.text !== "" && tok3.text == tok5.text && tok5.text == tok7.text) {
                if (tok3.text == "X") {
                    winX()
                } else if (tok3.text == "0") {
                    winO()
                }
            }else if (tok2.text !== "" && tok2.text == tok5.text && tok5.text == tok8.text) {
                if (tok2.text == "X") {
                    winX()
                } else if (tok2.text == "0") {
                    winO()
                }
            }
            else draw()
        }

        tok1.setOnClickListener {
            if (tok1.text == "") {
                tok1.setText(step[stepN])
                stepN = 1 - stepN
                tok1.isEnabled = false
                gameOver()
            }
        }
        tok2.setOnClickListener {
            if (tok2.text == "") {
                tok2.setText(step[stepN])
                stepN = 1 - stepN
                tok2.isEnabled = false
                gameOver()
            }
        }
        tok3.setOnClickListener {
            if (tok3.text == "") {
                tok3.setText(step[stepN])
                stepN = 1 - stepN
                tok3.isEnabled = false
                gameOver()
            }
        }
        tok4.setOnClickListener {
            if (tok4.text == "") {
                tok4.setText(step[stepN])
                stepN = 1 - stepN
                tok4.isEnabled = false
                gameOver()
            }
        }
        tok5.setOnClickListener {
            if (tok5.text == "") {
                tok5.setText(step[stepN])
                stepN = 1 - stepN
                tok5.isEnabled = false
                gameOver()
            }
        }
        tok6.setOnClickListener {
            if (tok6.text == "") {
                tok6.setText(step[stepN])
                stepN = 1 - stepN
                tok6.isEnabled = false
                gameOver()
            }
        }
        tok7.setOnClickListener {
            if (tok7.text == "") {
                tok7.setText(step[stepN])
                stepN = 1 - stepN
                tok7.isEnabled = false
                gameOver()
            }
        }
        tok8.setOnClickListener {
            if (tok8.text == "") {
                tok8.setText(step[stepN])
                stepN = 1 - stepN
                tok8.isEnabled = false
                gameOver()
            }
        }
        tok9.setOnClickListener {
            if (tok9.text == "") {
                tok9.setText(step[stepN])
                stepN = 1 - stepN
                tok9.isEnabled = false
                gameOver()
            }
        }
    }
}