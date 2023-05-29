package com.example.myapplication

import android.R.attr.bitmap
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import java.util.*


class TiktakActivity : AppCompatActivity() {
    private var stepN = 0
    private lateinit var step: Array<String>
    private lateinit var exitBtn: View
    private lateinit var tik1: Button
    private lateinit var tik2: Button
    private lateinit var tik3: Button
    private lateinit var tik4: Button
    private lateinit var tik5: Button
    private lateinit var tik6: Button
    private lateinit var tik7: Button
    private lateinit var tik8: Button
    private lateinit var tik9: Button
    private lateinit var tikButtons: Array<Button>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tiktak)

        initVariables()
        initGame()
    }

    private fun initVariables() {
        stepN = 0
        step = arrayOf("X", "0")
        exitBtn = findViewById<View>(R.id.exitToAboutScreen)
        tik1 = findViewById<Button>(R.id.tik1)
        tik2 = findViewById<Button>(R.id.tik2)
        tik3 = findViewById<Button>(R.id.tik3)
        tik4 = findViewById<Button>(R.id.tik4)
        tik5 = findViewById<Button>(R.id.tik5)
        tik6 = findViewById<Button>(R.id.tik6)
        tik7 = findViewById<Button>(R.id.tik7)
        tik8 = findViewById<Button>(R.id.tik8)
        tik9 = findViewById<Button>(R.id.tik9)
        tikButtons = arrayOf(tik1, tik2, tik3, tik4, tik5, tik6, tik7, tik8, tik9)
    }

    private fun initGame() {

        exitBtn.setOnClickListener {
            startActivity(Intent(this, AboutActivity::class.java))
        }

        fun draw() {
            val isBoardFull = arrayOf(tik1, tik2, tik3, tik4, tik5, tik6, tik7, tik8, tik9)
                .all { it.text != "" }

            if (isBoardFull) {
                startActivity(Intent(this, WinActivity::class.java))
            }
        }

        fun winX() {
            startActivity(Intent(this, XwinActivity::class.java))
        }

        fun winO() {
            startActivity(Intent(this, OwinActivity::class.java))
        }

        fun gameOver() {
            val winningCombinations = arrayOf(
                arrayOf(tik1, tik2, tik3),
                arrayOf(tik4, tik5, tik6),
                arrayOf(tik7, tik8, tik9),
                arrayOf(tik1, tik4, tik7),
                arrayOf(tik3, tik6, tik9),
                arrayOf(tik1, tik5, tik9),
                arrayOf(tik3, tik5, tik7),
                arrayOf(tik2, tik5, tik8)
            )

            for (combination in winningCombinations) {
                if (combination[0].text.isNotBlank() && combination[0].text == combination[1].text && combination[1].text == combination[2].text) {
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

        fun allTikFilled(): Boolean {
            return tikButtons.all { it.text.isNotBlank() }
        }

        fun random() {
            val tok = (1 until 10).random()
            val tik = tikButtons[tok - 1]

            if (tik.text.isBlank()) {
                tik.setText(step[stepN])
                stepN = 1 - stepN
                tik.isEnabled = false
                gameOver()
            } else if (allTikFilled()) {
                gameOver()
            } else {
                random()
            }
        }

        tik1.setOnClickListener {
            if (tik1.text == "") {
                tik1.setText(step[stepN])
                stepN = 1 - stepN
                tik1.isEnabled = false
                gameOver()
            }
            if (tik1.text == "X" && tik2.text == "X") {
                if (tik3.text == "") {
                    tik3.setText(step[stepN])
                    stepN = 1 - stepN
                    tik3.isEnabled = false
                    gameOver()

                } else if (tik3.text == "0") {
                    random()
                }
            } else if (tik1.text == "X" && tik3.text == "X") {
                if (tik2.text == "") {
                    tik2.setText(step[stepN])
                    stepN = 1 - stepN
                    tik2.isEnabled = false
                    gameOver()
                } else if (tik2.text == "0") {
                    random()
                }
            } else if (tik1.text == "X" && tik4.text == "X") {
                if (tik7.text == "") {
                    tik7.setText(step[stepN])
                    stepN = 1 - stepN
                    tik7.isEnabled = false
                    gameOver()
                } else if (tik7.text == "0") {
                    random()
                }
            } else if (tik1.text == "X" && tik7.text == "X") {
                if (tik4.text == "") {
                    tik4.setText(step[stepN])
                    stepN = 1 - stepN
                    tik4.isEnabled = false
                    gameOver()
                } else if (tik4.text == "0") {
                    random()
                }
            } else if (tik1.text == "X" && tik9.text == "X") {
                if (tik5.text == "") {
                    tik5.setText(step[stepN])
                    stepN = 1 - stepN
                    tik5.isEnabled = false
                    gameOver()
                } else if (tik5.text == "0") {
                    random()
                }
            } else if (tik1.text == "X" && tik5.text == "X") {
                if (tik9.text == "") {
                    tik9.setText(step[stepN])
                    stepN = 1 - stepN
                    tik9.isEnabled = false
                    gameOver()
                } else if (tik9.text == "0") {
                    random()
                }
            } else {
                random()
            }
        }
        tik2.setOnClickListener {
            if (tik2.text == "") {
                tik2.setText(step[stepN])
                stepN = 1 - stepN
                tik2.isEnabled = false
                gameOver()
            }
            if (tik2.text == "X" && tik3.text == "X") {
                if (tik1.text == "") {
                    tik1.setText(step[stepN])
                    stepN = 1 - stepN
                    tik1.isEnabled = false
                    gameOver()
                } else if (tik1.text == "0") {
                    random()
                }
            } else if (tik2.text == "X" && tik1.text == "X") {
                if (tik3.text == "") {
                    tik3.setText(step[stepN])
                    stepN = 1 - stepN
                    tik3.isEnabled = false
                    gameOver()
                } else if (tik3.text == "0") {
                    random()
                }
            } else if (tik2.text == "X" && tik5.text == "X") {
                if (tik8.text == "") {
                    tik8.setText(step[stepN])
                    stepN = 1 - stepN
                    tik8.isEnabled = false
                    gameOver()
                } else if (tik8.text == "0") {
                    random()
                }
            } else if (tik2.text == "X" && tik8.text == "X") {
                if (tik5.text == "") {
                    tik5.setText(step[stepN])
                    stepN = 1 - stepN
                    tik5.isEnabled = false
                    gameOver()
                } else if (tik5.text == "0") {
                    random()
                }
            } else {
                random()
            }
        }
        tik3.setOnClickListener {
            if (tik3.text == "") {
                tik3.setText(step[stepN])
                stepN = 1 - stepN
                tik3.isEnabled = false
                gameOver()
            }
            if (tik3.text == "X" && tik2.text == "X") {
                if (tik1.text == "") {
                    tik1.setText(step[stepN])
                    stepN = 1 - stepN
                    tik1.isEnabled = false
                    gameOver()
                } else if (tik1.text == "0") {
                    random()
                }
            } else if (tik3.text == "X" && tik1.text == "X") {
                if (tik2.text == "") {
                    tik2.setText(step[stepN])
                    stepN = 1 - stepN
                    tik2.isEnabled = false
                    gameOver()
                } else if (tik2.text == "0") {
                    random()
                }
            } else if (tik3.text == "X" && tik6.text == "X") {
                if (tik9.text == "") {
                    tik9.setText(step[stepN])
                    stepN = 1 - stepN
                    tik9.isEnabled = false
                    gameOver()
                } else if (tik9.text == "0") {
                    random()
                }
            } else if (tik3.text == "X" && tik9.text == "X") {
                if (tik6.text == "") {
                    tik6.setText(step[stepN])
                    stepN = 1 - stepN
                    tik6.isEnabled = false
                    gameOver()
                } else if (tik6.text == "0") {
                    random()
                }
            } else if (tik3.text == "X" && tik5.text == "X") {
                if (tik7.text == "") {
                    tik7.setText(step[stepN])
                    stepN = 1 - stepN
                    tik7.isEnabled = false
                    gameOver()
                } else if (tik7.text == "0") {
                    random()

                }
            } else if (tik3.text == "X" && tik7.text == "X") {
                if (tik5.text == "") {
                    tik5.setText(step[stepN])
                    stepN = 1 - stepN
                    tik5.isEnabled = false
                    gameOver()
                } else if (tik5.text == "0") {
                    random()
                }
            } else {
                random()
            }
        }
        tik4.setOnClickListener {
            if (tik4.text == "") {
                tik4.setText(step[stepN])
                stepN = 1 - stepN
                tik4.isEnabled = false
                gameOver()
            }
            if (tik4.text == "X" && tik5.text == "X") {
                if (tik6.text == "") {
                    tik6.setText(step[stepN])
                    stepN = 1 - stepN
                    tik6.isEnabled = false
                    gameOver()
                } else if (tik6.text == "0") {
                    random()
                }
            } else if (tik4.text == "X" && tik7.text == "X") {
                if (tik1.text == "") {
                    tik1.setText(step[stepN])
                    stepN = 1 - stepN
                    tik1.isEnabled = false
                    gameOver()
                } else if (tik1.text == "0") {
                    random()
                }
            } else if (tik4.text == "X" && tik1.text == "X") {
                if (tik7.text == "") {
                    tik7.setText(step[stepN])
                    stepN = 1 - stepN
                    tik7.isEnabled = false
                    gameOver()
                } else if (tik7.text == "0") {
                    random()
                }
            } else if (tik4.text == "X" && tik6.text == "X") {
                if (tik5.text == "") {
                    tik5.setText(step[stepN])
                    stepN = 1 - stepN
                    tik5.isEnabled = false
                    gameOver()
                } else if (tik5.text == "0") {
                    random()
                }
            } else {
                random()
            }
        }
        tik5.setOnClickListener {
            if (tik5.text == "") {
                tik5.setText(step[stepN])
                stepN = 1 - stepN
                tik5.isEnabled = false
                gameOver()
            }
            if (tik5.text == "X" && tik9.text == "X") {
                if (tik1.text == "") {
                    tik1.setText(step[stepN])
                    stepN = 1 - stepN
                    tik1.isEnabled = false
                    gameOver()
                } else if (tik1.text == "0") {
                    random()
                }
            } else if (tik5.text == "X" && tik8.text == "x") {
                if (tik2.text == "") {
                    tik2.setText(step[stepN])
                    stepN = 1 - stepN
                    tik2.isEnabled = false
                    gameOver()
                } else if (tik2.text == "0") {
                    random()
                }
            } else if (tik5.text == "X" && tik7.text == "X") {
                if (tik3.text == "") {
                    tik3.setText(step[stepN])
                    stepN = 1 - stepN
                    tik3.isEnabled = false
                    gameOver()
                } else if (tik3.text == "0") {
                    random()
                }
            } else if (tik5.text == "X" && tik6.text == "X") {
                if (tik4.text == "") {
                    tik4.setText(step[stepN])
                    stepN = 1 - stepN
                    tik4.isEnabled = false
                    gameOver()
                } else if (tik4.text == "0") {
                    random()
                }
            } else if (tik5.text == "X" && tik4.text == "X") {
                if (tik6.text == "") {
                    tik6.setText(step[stepN])
                    stepN = 1 - stepN
                    tik6.isEnabled = false
                    gameOver()
                } else if (tik6.text == "0") {
                    random()
                }
            } else if (tik5.text == "X" && tik3.text == "X") {
                if (tik7.text == "") {
                    tik7.setText(step[stepN])
                    stepN = 1 - stepN
                    tik7.isEnabled = false
                    gameOver()
                } else if (tik7.text == "0") {
                    random()

                }
            } else if (tik5.text == "X" && tik2.text == "X") {
                if (tik8.text == "") {
                    tik8.setText(step[stepN])
                    stepN = 1 - stepN
                    tik8.isEnabled = false
                    gameOver()
                } else if (tik8.text == "0") {
                    random()
                }
            } else if (tik5.text == "X" && tik1.text == "X") {
                if (tik9.text == "") {
                    tik9.setText(step[stepN])
                    stepN = 1 - stepN
                    tik9.isEnabled = false
                    gameOver()
                } else if (tik9.text == "0") {
                    random()
                }
            } else {
                random()
            }
        }
        tik6.setOnClickListener {
            if (tik6.text == "") {
                tik6.setText(step[stepN])
                stepN = 1 - stepN
                tik6.isEnabled = false
                gameOver()
            }
            if (tik6.text == "X" && tik3.text == "X") {
                if (tik9.text == "") {
                    tik9.setText(step[stepN])
                    stepN = 1 - stepN
                    tik9.isEnabled = false
                    gameOver()
                } else if (tik9.text == "0") {
                    random()
                }
            } else if (tik6.text == "X" && tik9.text == "X") {
                if (tik3.text == "") {
                    tik3.setText(step[stepN])
                    stepN = 1 - stepN
                    tik3.isEnabled = false
                    gameOver()
                } else if (tik3.text == "0") {
                    random()
                }
            } else if (tik6.text == "X" && tik5.text == "X") {
                if (tik4.text == "") {
                    tik4.setText(step[stepN])
                    stepN = 1 - stepN
                    tik4.isEnabled = false
                    gameOver()
                } else if (tik4.text == "0") {
                    random()
                }
            } else if (tik6.text == "X" && tik4.text == "X") {
                if (tik5.text == "") {
                    tik5.setText(step[stepN])
                    stepN = 1 - stepN
                    tik5.isEnabled = false
                    gameOver()
                } else if (tik5.text == "0") {
                    random()
                }
            } else {
                random()
            }
        }
        tik7.setOnClickListener {
            if (tik7.text == "") {
                tik7.setText(step[stepN])
                stepN = 1 - stepN
                tik7.isEnabled = false
                gameOver()
            }
            if (tik7.text == "X" && tik5.text == "X") {
                if (tik3.text == "") {
                    tik3.setText(step[stepN])
                    stepN = 1 - stepN
                    tik3.isEnabled = false
                    gameOver()
                } else if (tik3.text == "0") {
                    random()
                }
            } else if (tik7.text == "X" && tik1.text == "X") {
                if (tik4.text == "") {
                    tik4.setText(step[stepN])
                    stepN = 1 - stepN
                    tik4.isEnabled = false
                    gameOver()
                } else if (tik4.text == "0") {
                    random()
                }
            } else if (tik7.text == "X" && tik8.text == "X") {
                if (tik9.text == "") {
                    tik9.setText(step[stepN])
                    stepN = 1 - stepN
                    tik9.isEnabled = false
                    gameOver()
                } else if (tik9.text !== "") {
                    random()
                }
            } else if (tik7.text == "X" && tik9.text == "X") {
                if (tik8.text == "") {
                    tik8.setText(step[stepN])
                    stepN = 1 - stepN
                    tik8.isEnabled = false
                    gameOver()
                } else if (tik8.text == "0") {
                    random()
                }
            } else if (tik7.text == "X" && tik3.text == "X") {
                if (tik5.text == "") {
                    tik5.setText(step[stepN])
                    stepN = 1 - stepN
                    tik5.isEnabled = false
                    gameOver()
                } else if (tik5.text == "0") {
                    random()
                }
            } else if (tik7.text == "X" && tik4.text == "X") {
                if (tik1.text == "") {
                    tik1.setText(step[stepN])
                    stepN = 1 - stepN
                    tik1.isEnabled = false
                    gameOver()
                } else if (tik1.text == "0") {
                    random()
                }
            } else {
                random()
            }
        }
        tik8.setOnClickListener {
            if (tik8.text == "") {
                tik8.setText(step[stepN])
                stepN = 1 - stepN
                tik8.isEnabled = false
                gameOver()
            }
            if (tik8.text == "X" && tik5.text == "X") {
                if (tik2.text == "") {
                    tik2.setText(step[stepN])
                    stepN = 1 - stepN
                    tik2.isEnabled = false
                    gameOver()
                } else if (tik2.text == "0") {
                    random()
                }
            } else if (tik8.text == "X" && tik9.text == "X") {
                if (tik7.text == "") {
                    tik7.setText(step[stepN])
                    stepN = 1 - stepN
                    tik7.isEnabled = false
                    gameOver()
                } else if (tik7.text == "0") {
                    random()
                }
            } else if (tik8.text == "X" && tik7.text == "X") {
                if (tik9.text == "") {
                    tik9.setText(step[stepN])
                    stepN = 1 - stepN
                    tik9.isEnabled = false
                    gameOver()
                } else if (tik9.text == "0") {
                    random()
                }
            } else if (tik8.text == "X" && tik2.text == "X") {
                if (tik5.text == "") {
                    tik5.setText(step[stepN])
                    stepN = 1 - stepN
                    tik5.isEnabled = false
                    gameOver()
                } else if (tik8.text == "0") {
                    random()
                }
            } else {
                random()
            }
        }
        tik9.setOnClickListener {
            if (tik9.text == "") {
                tik9.setText(step[stepN])
                stepN = 1 - stepN
                tik9.isEnabled = false
                gameOver()
            }
            if (tik9.text == "X" && tik5.text == "X") {
                if (tik1.text == "") {
                    tik1.setText(step[stepN])
                    stepN = 1 - stepN
                    tik1.isEnabled = false
                    gameOver()
                } else if (tik1.text == "0") {
                    random()
                }
            } else if (tik9.text == "X" && tik1.text == "X") {
                if (tik5.text == "") {
                    tik5.setText(step[stepN])
                    stepN = 1 - stepN
                    tik5.isEnabled = false
                    gameOver()
                } else if (tik5.text == "0") {
                    random()
                }
            } else if (tik9.text == "X" && tik8.text == "X") {
                if (tik7.text == "") {
                    tik7.setText(step[stepN])
                    stepN = 1 - stepN
                    tik7.isEnabled = false
                    gameOver()
                } else if (tik7.text == "0") {
                    random()
                }
            } else if (tik9.text == "X" && tik7.text == "X") {
                if (tik8.text == "") {
                    tik8.setText(step[stepN])
                    stepN = 1 - stepN
                    tik8.isEnabled = false
                    gameOver()
                } else if (tik8.text == "0") {
                    random()
                }
            } else if (tik9.text == "X" && tik6.text == "X") {
                if (tik3.text == "") {
                    tik3.setText(step[stepN])
                    stepN = 1 - stepN
                    tik3.isEnabled = false
                    gameOver()
                } else if (tik3.text == "0") {
                    random()
                }
            } else if (tik9.text == "X" && tik3.text == "X") {
                if (tik6.text == "") {
                    tik6.setText(step[stepN])
                    stepN = 1 - stepN
                    tik6.isEnabled = false
                    gameOver()
                } else if (tik6.text == "0") {
                    random()
                }
            } else {
                random()
            }
        }
    }
}






