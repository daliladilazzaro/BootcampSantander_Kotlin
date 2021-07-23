package com.example.devintegrado

import android.database.Cursor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.loader.app.LoaderManager
import androidx.loader.content.CursorLoader
import androidx.loader.content.Loader
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.devintegrado.database.NotesDatabaseHelper.Companion.TITLE_NOTES
import com.example.devintegrado.database.NotesProvider.Companion.URI_NOTES
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity(), LoaderManager.LoaderCallbacks<Cursor>{
    lateinit var notesRecycle:RecyclerView
    lateinit var noteAdd: FloatingActionButton

    lateinit var adapter: NotesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        noteAdd = findViewById(R.id.note_add)
        noteAdd.setOnClickListener{ }

        adapter = NotesAdapter()
        adapter.setHasStableIds(true)

        notesRecycle = findViewById(R.id.notes_reclycler)
        notesRecycle.layoutManager = LinearLayoutManager(this)
        notesRecycle.adapter = adapter
    }

    //instancia aquilo que vou buscar, no caso a pesquisa feita no contentprovider
    override fun onCreateLoader(id: Int, args: Bundle?): Loader<Cursor> =
        CursorLoader(this, URI_NOTES, null, null, null, TITLE_NOTES)

    //pega os dados recebidos e manipula conforme achar melhor
    override fun onLoadFinished(loader: Loader<Cursor>, data: Cursor?) {
        if (data!= null) {

        }
    }
    //acaba com a pesquisa em segundo plano creadeloadermanager
    override fun onLoaderReset(loader: Loader<Cursor>) {

    }
}