package uz.gita.logoquizapp

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RadioButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import uz.gita.logoquizapp.dialog.ConfirmDialog
import uz.gita.logoquizapp.dialog.ResultDialog
import uz.gita.logoquizapp.domain.Repository

class MainActivity : AppCompatActivity() {
    private lateinit var variants: ArrayList<RadioButton>
    private var index = 0
    private var repository = Repository.getInstance()
    private lateinit var dotsList: ArrayList<View>
    private lateinit var imgQuestion: ImageView
    private lateinit var questionLevel: TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        variants = ArrayList()
        dotsList = ArrayList()
        val container: LinearLayout = findViewById(R.id.linersContainer)
        for (i in 0 until container.childCount) {
            dotsList.add(container.getChildAt(i))
            container.getChildAt(i).setOnClickListener {
                setDotsColor()
                index = i
                loadQuestion()
            }
        }
        imgQuestion = findViewById(R.id.imgQuestion)
        variants.add(findViewById(R.id.radio1))
        variants.add(findViewById(R.id.radio2))
        variants.add(findViewById(R.id.radio3))
        variants.add(findViewById(R.id.radio4))

        findViewById<AppCompatButton>(R.id.buttonNext).setOnClickListener {
            setDotsColor()
            index++
            if (index == 10) {
                index = 0
            }
            loadQuestion()
        }
        findViewById<AppCompatButton>(R.id.buttonSkip).setOnClickListener {
            setDotsColor()
            index--
            if (index == -1) {
                index = 9
            }
            loadQuestion()
        }
        findViewById<ImageView>(R.id.buttonBack).setOnClickListener {
            showConfirmDialog()
        }
        loadQuestion()
        setClickEvents()
    }

    private fun setDotsColor() {
        if (repository.getQuestionByIndex(index).select != -1) dotsList[index].setBackgroundColor(Color.parseColor("#FFE500"))
        else dotsList[index].setBackgroundColor(Color.parseColor("#FFFFFF"))
    }

    @SuppressLint("ResourceAsColor")
    private fun setClickEvents() {
        for (i in 0 until variants.size) variants[i].setOnClickListener {
            clearSelectRadios()
            variants[i].isChecked = true
            repository.setSelected(index, i)
        }

        findViewById<ImageView>(R.id.finishQuiz).setOnClickListener {
            showConfirmDialog()
        }
    }

    private fun showConfirmDialog() {
        val dialog = ConfirmDialog()
        dialog.setShowResultsListener {
            showResultDialog()
        }
        dialog.show(supportFragmentManager, "Confirm")
    }

    private fun loadQuestion() {
        clearSelectRadios()
        dotsList[index].setBackgroundColor(Color.parseColor("#06CDF0"))
        val question = repository.getQuestionByIndex(index)
        imgQuestion.setImageResource(question.question)
        for (i in 0 until variants.size) variants[i].text = question.variants[i]
        if (question.select != -1) {
            variants[question.select].isChecked = true
        }
        findViewById<TextView>(R.id.txtQuestionCount).text = "${index + 1}"
    }

    private fun clearSelectRadios() {
        for (radio in variants) {
            radio.isChecked = false
        }
    }

    private fun showResultDialog() {
        val dialog = ResultDialog(repository.getScore())
        dialog.setShowResultsListener {
            repository.newGame()
            clearSelectRadios()
            finish()
        }
        dialog.setShowNewGameListener {
            repository.newGame()
            clearSelectRadios()
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
        dialog.show(supportFragmentManager, "Result Sialog")
    }

    override fun onBackPressed() {
        showConfirmDialog()
    }
}