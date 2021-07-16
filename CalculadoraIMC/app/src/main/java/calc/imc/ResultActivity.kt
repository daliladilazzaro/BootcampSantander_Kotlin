package calc.imc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.w("lifecycle", "entrei no CREATE - estou criando a tela.")
        /* finish()*/
    }

    override fun onStart() {
        super.onStart()
        Log.w("lifecycle", "entrei no START - deixei a tela visível para você.")
    }

    override fun onResume() {
        super.onResume()
        Log.w("lifecycle", "entrei no RESUME - agora você pode interagir com a tela.")
    }
    override fun onPause() {
        super.onPause()
        Log.w("lifecycle", "entrei no PAUSE - a tela perdeu o foco, você não pode mais interagir.")
    }
    override fun onStop() {
        super.onStop()
        Log.w("lifecycle", "entrei no STOP - a tela não está mais visível, mas ainda existe.")
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.w("lifecycle", "\nentrei no DESTROY - oh não! a tela foi destruída.")
    }
    override fun onRestart() {
        super.onRestart()
        Log.w("lifecycle", "\nentrei no RESTART - a tela está retomando o foco.")
    }
}