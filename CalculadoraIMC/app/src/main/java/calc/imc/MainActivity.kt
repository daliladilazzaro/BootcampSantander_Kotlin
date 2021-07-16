package calc.imc

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListeners()
    }

    private fun setListeners(){
        altura?.doOnTextChanged { text ->
            //Toast.makeTeste(this, text.toString(), Toast.LENGTH_SHORT).show()
        }
        peso?.doOnTextChanged { text -> _, _, _ ->
            //LittleText?.text = text
        }
        calcBotao?.setOnClickListener{
            calcular(peso.text.toString(), altura.text.toString90)
        }
    }
    private fun calcularIMC(peso: String, altura:String){
        val peso = peso.toFloatOrNull()
        val altura = altura.toFloatOrNull()
        if (peso != null && altura != null){
            val imc = peso / (altura * altura)
            LittleText.text="Seu peso é: $imc".format(imc)
        }
    }
}