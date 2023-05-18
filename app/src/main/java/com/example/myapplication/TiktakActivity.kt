package com.example.myapplication

import android.R.attr.bitmap
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import java.util.*


class TiktakActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tiktak)

        var step = arrayOf("X", "0")
        var stepN = 0

        val knopka = findViewById<View>(R.id.exit4)
        val tik1 = findViewById<Button>(R.id.tik1)
        val tik2 = findViewById<Button>(R.id.tik2)
        val tik3 = findViewById<Button>(R.id.tik3)
        val tik4 = findViewById<Button>(R.id.tik4)
        val tik5 = findViewById<Button>(R.id.tik5)
        val tik6 = findViewById<Button>(R.id.tik6)
        val tik7 = findViewById<Button>(R.id.tik7)
        val tik8 = findViewById<Button>(R.id.tik8)
        val tik9 = findViewById<Button>(R.id.tik9)


        knopka.setOnClickListener {
            startActivity(Intent(this, AboutActivity::class.java))
        }

        fun draw() {
            val isBoardFull = listOf(tik1, tik2, tik3, tik4, tik5, tik6, tik7, tik8, tik9)
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
            val winCombinations = listOf(
                listOf(tik1, tik2, tik3),
                listOf(tik4, tik5, tik6),
                listOf(tik7, tik8, tik9),
                listOf(tik1, tik4, tik7),
                listOf(tik3, tik6, tik9),
                listOf(tik1, tik5, tik9),
                listOf(tik3, tik5, tik7),
                listOf(tik2, tik5, tik8)
            )

            for (combination in winCombinations) {
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
        val tikButtons = listOf(tik1, tik2, tik3, tik4, tik5, tik6, tik7, tik8, tik9)
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
                }
                else if (tik5.text == "X" && tik8.text == "x") {
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






