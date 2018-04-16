package tipcalc.nguyen51.washington.edu

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.math.BigDecimal

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tipBtn.isClickable = false

        amount.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                if (tipBtn.isClickable) {
                    tipBtn.setOnClickListener {handleTipClick()}
                }
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                tipBtn.isClickable = !amount.text.isEmpty()

            }

            override fun afterTextChanged(s: Editable?) {
                if (tipBtn.isClickable) {
                    tipBtn.setOnClickListener {handleTipClick()}
                }
            }
        })
    }

    fun handleTipClick() {
        var total = amount.text.toString().toDouble()
        var tip: Double = total * 0.15
        var tipRounded = "%.2f".format(tip)
        Toast.makeText(this, "Recommended 15% Tip: $" + tipRounded, Toast.LENGTH_LONG).show()
    }
}
