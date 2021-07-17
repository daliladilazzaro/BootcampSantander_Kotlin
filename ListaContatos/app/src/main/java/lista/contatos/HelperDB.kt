package lista.contatos

import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import java.util.*

class HelperDB (context: Context): SQLiteOpenHelper(context, NOME_BANCO, null, VERSAO_ATUAL) {

    companion object(private val NOME_BANCO = "contato.db", private val VERSAO_ATUAL = 1)

    val TABLE_NAME = "contato"
    val COLUMNS_ID = "id"
    val COLUMNS_TELEFONE = "telefone"
    val COLUMNS_NOME = "nome"
    val DROP_TABLE = "DROP TABLE IF EXISTS $TABLE_NAME"
    val CREATE_TABLE =
        "CREATE TABLE $TABLE_NAME ($COLUMNS_ID INTEGER NOT NULL, $$COLUMNS_NOME TEXT NOT NULL," +
                "$COLUMNS_TELEFONE TEXT NOT NULL, PRIMARY KEY($COLUMNS_ID AUTOINCREMENT)"

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(CREATE_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        if (oldVersion != newVersion) {
            db?.execSQL(DROP_TABLE)
        }
        onCreate(db)
    }

    fun buscarContatos(busca: String, isBuscaPorId:Boolean=false): List<ContatoVO> {
       // salvarContato(ContatoVO(0, "", ""))
        val db = readableDatabase ?: return mutableListOf()
        var lista = mutableListOf<ContatosVO>()
        var where:String?=null
        var args :Array<String>=arrayOf()
        if (isBuscaPorId){
      //  val sql = "SELECT * FROM $TABLE_NAME WHERE $COLUMNS_NOME LIKE ?"
         where = "$COLUMNS_ID  = ?"
        //var buscaComPercentual = "%$busca%"
         args = arrayOf("%$busca%")
        }else{
         where = "$COLUMNS_NOME LIKE ?"
         args = arrayOf("%$busca%")
        }
       // var cursor = db.rawQuery(sql, arrayOf(buscaComPercentual))
        var cursor = db.query(TABLE_NAME, null, where, buscaComPercentual, null, null, null)

        if (cursor == null){
            db.close()
        return mutableListOf()
        }

        while (cursor.moveToNext()) {
            var contato = ContatosVO(
            cursor.getInt(cursor.getColumnIndex(COLUMNS_ID)),
            cursor.getString(cursor.getColumnIndex(COLUMNS_NOME)),
            cursor.getString(cursor.getColumnIndex(COLUMNS_TELEFONE))
            )
            lista.add(contato)
        }
        return lista
    }

    fun salvarContato(contato: ContatosVO){
        val db = writableDatabase?:return
       // val sql = "INSERT INTO $TABLE_NAME ($COLUMNS_NOME, $COLUMNS_TELEFONE) VALUES(?, ?)"
        //var array = arrayOf(contato.nome, contato.telefone)
        //db.execSQL(sql, array)
        var content = ContentValues()
        content.put(COLUMNS_NOME, contato.nome)
        content.put(COLUMNS_TELEFONE, contato.telefone)
        db.insert(TABLE_NAME, null, content)
        db.close()
    }
    fun deletarContato(id:Int){
        val db=writableDatabase?:return
       // val where="id =?"
        //val args= arrayOf("$id")
        //db.delete(TABLE_NAME, where, args)
        val sql = "DELETE FROM $TABLE_NAME WHERE $COLUMNS_ID = ?"
        val arg = arrayOf("$id")
        db.execSQL(sql, arg)
        db.close()
    }
    fun updateContato(contato:ContatoVO){
        val db=writableDatabase?:return
        /*val content=ContentValues()
        content.put(COLUMNS_NOME, contato.nome)
        content.put(COLUMNS_TELEFONE, contato.telefone)
        val where="id = ?"
        val arg = arrayOf("${contato.id}")
        db.update(TABLE_NAME,content, where, arg)*/
        val sql = "UPDATE $TABLE_NAME SET $COLUMNS_NOME = ?, $COLUMNS_TELEFONE = ? WHERE $COLUMNS_ID = ?"
        val arg = arrayOf(contato.nome, contato.telefone, contato.id)
        db.execSQL(sql, arg)
        db.close()
    }
}