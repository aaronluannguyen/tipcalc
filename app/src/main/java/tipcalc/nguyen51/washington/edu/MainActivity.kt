package tipcalc.nguyen51.washington.edu

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //amount.addTextChangedListener()

        tipBtn.setOnClickListener {handleTipClick()}
    }

    fun handleTipClick() {
        var total = amount.text.toString().toDouble()

        var tip: Number = total * 0.15

        Toast.makeText(this, "Recommended Tip: $" + tip.toString(), Toast.LENGTH_LONG).show()
    }
}
