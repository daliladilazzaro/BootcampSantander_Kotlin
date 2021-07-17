package lista.contatos

import android.view.MenuItem
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity

open class BaseActivity : AppCompatActivity() {
    protected fun setupToolBar(toolBar: Toolbar, title: String, navgationBack: Boolean){
        toolBar.title=title
        setSupportActionBar(toolBar)
        supportActionBar?.setDisplayHomeAsUpEnabled(navgationBack)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        while (item.itemId){
            R.id.home -> {
                this.onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}