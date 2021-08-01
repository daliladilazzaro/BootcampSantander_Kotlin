/*package com.br.natanfc.filmesflix.repository

import android.util.Log
import com.br.natanfc.filmesflix.view.MovieRestApiTask
import com.br.natanfc.filmesflix.domain.Movie

class MovieRepository(private val movieRestApiTask: MovieRestApiTask) {

    companion object{
        const val TAG="MovieRepository"
    }

    private val movieList= arrayListOf<Movie>()

    //pra ter acesso ao banco de dados
    fun getAllMovies():List<Movie>{
        val request=movieRestApiTask.retrofitApi().getAllMovies().execute()
        if (request.isSuccessful){
        //ele retorna toda a lista
            request.body()?.let {
                movieList.addAll(it)
            }
        }
        else{
            request.errorBody()?.let {
                Log.d(TAG, it.toString())
            }
        }
        return movieList
    }
}
*/