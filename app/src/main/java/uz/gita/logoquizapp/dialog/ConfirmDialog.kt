package uz.gita.logoquizapp.dialog

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.DialogFragment
import uz.gita.logoquizapp.R

class ConfirmDialog : DialogFragment(R.layout.dialog_confirm) {

    private var showResultsListener: ((Unit) -> Unit)? = null
    fun setShowResultsListener(block: (Unit) -> Unit) {
        showResultsListener = block
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<AppCompatButton>(R.id.buttonYes).setOnClickListener {
            showResultsListener?.invoke(Unit)
            dismiss()
        }
        view.findViewById<AppCompatButton>(R.id.buttonNo).setOnClickListener {
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


