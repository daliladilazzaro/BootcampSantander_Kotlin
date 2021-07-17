package lista.contatos

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import java.lang.Exception

class MainActivity : BaseActivity() {

    private val adapter:ContatoAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
      //  geraListaContatos()
        setupToolBar(toolBar, "Lista de contatos", false)
        setupRecyclerView()
        setupOnClicks()
    }


    private fun setupOnClicks(){
        fab.setOnClickListener{onClickAdd()}
        ivBuscar.setOnClickListener{onClickBuscar}
    }
    private fun setupRecyclerView(){
        recyclerView.LayoutManager = LinearLayoutManager(this)
        adapter= ContatoAdapter(this, ContatoSingleton.lista){onClickItemRecyclerView(it)}
        recyclerView.adapter=adapter
    }

  //  private fun geraListaContatos(){
    //    ContatoSingleton.lista.add(ContatosVO(1,"Joelma", "(11) 98745-9874"))
      //  ContatoSingleton.lista.add(ContatosVO(2,"Walter", "(12) 97452-8614"))
     //   ContatoSingleton.lista.add(ContatosVO(3,"Amado", "(27) 91452-9657"))
    //}

    override fun onResume() {
        super.onResume()
        //adapter?.notifyDataSetChanged()
        onClickBuscar()
    }
    private fun onClickAdd(){
        val intent = Intent(this, ContatoActivity::class.java)
        startActivity(intent)
    }
    private fun onClickItemRecyclerView(index:Int){
        val intent = Intent(this, ContatoActivity::class.java)
        intent.putExtra("index", index)
        startActivity(intent)
    }
    private fun onClickBuscar(){
        val buscar = etBuscar.text.toString()
        progress.visibility = View.VISIBLE
     //   Thread.sleep(5000000)
        Thread(Runnable {
        Thread.sleep(3000)
        var listaFiltrada: List<ContatosVO> = mutableListOf()
        try {
        listaFiltrada=ContatoApplication.instance.helperDB?.buscarContatos(buscar) ?: mutableListOf()
        }catch (ex: Exception){
            ex.printStackTrace()
        }
            runOnUiThread {
                adapter = ContatoAdapter(this, listaFiltrada) { onClickItemRecyclerView(it) }
                recyclerView.adapter = adapter
                progress.visibility = View.GONE
                Toast.makeText(this, "Buscar por $buscar", Toast.LENGTH_SHORT).show()
            }
        }).start()
    }
}