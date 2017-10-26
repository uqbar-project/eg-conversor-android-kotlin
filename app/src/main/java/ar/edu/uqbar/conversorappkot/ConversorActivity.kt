package ar.edu.uqbar.conversorappkot

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import java.text.DecimalFormat
import java.text.NumberFormat

class Conversor {
    var millas = 0.0
    var kilometros = 0.0

    fun convertir() {
        kilometros = millas * 1.609344
    }

    fun kilometrosAsString() : String {
        return DecimalFormat("#######0.000").format(kilometros).replace(".", ",")
    }
}

class ConversorActivity : AppCompatActivity() , View.OnClickListener {
    val conversor = Conversor()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_conversor)
        findViewById(R.id.conversor_convertir).setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        val millas = (findViewById(R.id.conversor_millas) as EditText).text.toString()
        conversor.millas = java.lang.Double.valueOf(millas)
        conversor.convertir()
        (findViewById(R.id.conversor_kilometros) as TextView).setText(conversor.kilometrosAsString())
    }

}