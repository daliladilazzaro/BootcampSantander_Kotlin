package lista.contatos

import android.os.Bundle
import android.view.View

class ContatoActivity : BaseActivity () {

    private var index:Int=-1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contato)
        setupToolBar(toolBar, "Contato", true)
        setupContato()
        btnSalvarContato.setOnClickListener{onClickSalvarContato()}
    }
    private fun setupContato(){
        index = intent.getIntExtra("index", -1)
        if (index == -1){
            btnExluirContato.visibility=view.GONE
            return
        }
        progress.visibility = View.VISIBLE
        Thread(Runnable {
        Thread.sleep(1500)

        var lista = ContatoApplication.instance.helperDB?.buscarContatos("$index", true)?:return@Runnable
        var contato=lista.getOrNull(0) ?: return@Runnable
      //  etNome.setText(ContatoSingleton.lista[index].nome)
        //etTelefone.setText(ContatoSingleton.lista[index].telefone)
            runOnUiThread {
                etNome.setText(contato.nome)
                etTelefone.setText(contato.telefone)
                progress.visibility = View.GONE
            }
        }).start()
    }
    private fun onClickSalvarContato(){
        val nome = etNome.text.toString()
        val telefone = etTelefone.text.toSring()
        val contato = ContatosVO(idContato, nome, telefone)
        progress.visibility = View.VISIBLE
        Thread(Runnable {
            Thread.sleep(1500)
        if (index == -1){
         //   ContatoSingleton.lista.add(contato)
            ContatoApplication.instance.helperDB?.salvarContato(contato)
        }else{
           // ContatoSingleton.lista.set(index, contato)
            ContatoApplication.instance.helperDB?.updateContato(contato)
        }
            runOnUiThread {
                progress.visibility = View.GONE
                finish()
            }
        }).start()
    }
    fun onClickExcluirContato(View){
        if (index > -1){
            progress.visibility = View.VISIBLE
            Thread(Runnable {
                Thread.sleep(1500)
           // ContatoSingleton.lista.removeAt(index)
               ContatoApplication.instance.helperDB?.deletarContato(index)
                runOnUiThread {
                    progress.visibility = android.view.View.GONE
                    finish()
                }
            }).start()
        }
    }
}