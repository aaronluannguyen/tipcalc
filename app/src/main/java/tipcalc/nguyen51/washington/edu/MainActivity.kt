package tipcalc.nguyen51.washington.edu

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.Gravity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()

        tipBtn.isClickable = false

        amount.setOnClickListener({
            if (amount.text.isEmpty()) {
                defaultMoneySign()
            }
        })

        amount.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                tipBtn.isClickable = amount.text.length > 1
            }

            override fun afterTextChanged(s: Editable?) {
                if (amount.text.isEmpty()) {
                    defaultMoneySign()
                }
                when (tipBtn.isClickable) {
                    true -> {
                        tipBtn.setOnClickListener {handleTipClick()}
                        tipBtn.setBackgroundColor(Color.GREEN)
                    }
                    false -> tipBtn.setBackgroundColor(Color.LTGRAY)
                }
            }
        })
    }

    fun handleTipClick() {
        var total = amount.text.toString().substring(1).toDouble()
        var tip: Double = total * 0.15
        var tipRounded = "%.2f".format(tip)
        var toastMessage = Toast.makeText(this, "Recommended 15% Tip: $" + tipRounded, Toast.LENGTH_LONG)
        toastMessage.setGravity(Gravity.CENTER, 0 , 0)
        toastMessage.show()
    }

    fun textToMoney(text: Editable): String {
        if (text.toString().length > 1) {
            var numTimes100 = text.toString().substring(1).toDouble() * 1000
            var num = numTimes100 / 100
            var roundedNumString = "%.2f".format(num)
            return "$" + roundedNumString
        }
        return "$"
    }

    fun defaultMoneySign() {
        amount.setText("$")
        amount.setSelection(amount.text.length)
    }
}
