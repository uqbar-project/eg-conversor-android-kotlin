package ar.edu.uqbar.conversorappkot

import android.app.Activity
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import java.text.DecimalFormat
import kotlinx.android.synthetic.main.activity_conversor.*
import android.widget.TextView
import ar.edu.uqbar.conversorappkot.R.string.convertir
import android.widget.EditText
import ar.edu.uqbar.conversorappkot.R.id.conversor_convertir


class Conversor {
    var millas = 0.0
    var kilometros = 0.0

    fun convertir() {
        kilometros = millas * 1.609344
    }

    fun kilometrosAsString(): String {
        return DecimalFormat("#######0.000").format(kilometros).replace(".", ",")
    }
}

class ConversorActivity : Activity(), View.OnClickListener {
    val conversor = Conversor()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_conversor)
        conversor_convertir.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        try {
            val millas = conversor_millas.text.toString()
            if (millas.trim().equals("")) {
                Toast.makeText(this.getApplicationContext(), "Debe ingresar un valor", Toast.LENGTH_LONG).show()
                return
            }
            conversor.millas = java.lang.Double.valueOf(millas)
            conversor.convertir()
            conversor_kilometros.text = conversor.kilometrosAsString()
        } catch (e: NumberFormatException) {
            Toast.makeText(this.getApplicationContext(), "Debe ingresar un valor numérico", Toast.LENGTH_LONG).show();
        }
    }

}