package uz.gita.logoquizapp.dialog

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.DialogFragment
import uz.gita.logoquizapp.R

class ResultDialog(private val score: Int) : DialogFragment(R.layout.dialog_result) {

    private var showResultsListener: ((Unit) -> Unit)? = null
    fun setShowResultsListener(block: (Unit) -> Unit) {
        showResultsListener = block
    }

    private var showNewGameListener: ((Unit) -> Unit)? = null
    fun setShowNewGameListener(block: (Unit) -> Unit) {
        showNewGameListener = block
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val txtCong = view.findViewById<TextView>(R.id.txtCongratulations)
        val txtScore = view.findViewById<TextView>(R.id.txtScore)
        if (score < 5) {
            txtCong.text = "Very Bad!"
            txtScore.setTextColor(Color.parseColor("#FF0000"))
        } else if (score < 7) {
            txtCong.text = "Note Bad!"
            txtScore.setTextColor(Color.parseColor("#FFE500"))
        } else if (score < 9) {
            txtCong.text = "Good!"
            txtScore.setTextColor(Color.parseColor("#FFFFFF"))
        } else {
            txtCong.text = "Congratulations!"
            txtScore.setTextColor(Color.parseColor("#26FF00"))
        }
        isCancelable = false
        txtScore.text = score.toString()
        view.findViewById<AppCompatButton>(R.id.buttonShowAnswers).setOnClickListener {
            showResultsListener?.invoke(Unit)
            dismiss()
        }
        view.findViewById<AppCompatButton>(R.id.buttonNewGame).setOnClickListener {
            showNewGameListener?.invoke(Unit)
            dismiss()
        }
    }

    override fun onResume() {
        super.onResume()
        val params = dialog!!.window!!.attributes
        params.width = ViewGroup.LayoutParams.MATCH_PARENT
        params.height = ViewGroup.LayoutParams.WRAP_CONTENT
        dialog!!.window!!.attributes = params
    }

}


