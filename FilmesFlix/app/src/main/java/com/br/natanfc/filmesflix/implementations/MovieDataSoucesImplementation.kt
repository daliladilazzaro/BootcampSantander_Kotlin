package com.br.natanfc.filmesflix.implementations

import android.util.Log
import com.br.natanfc.filmesflix.presenter.MovieRestApiTask
import com.br.natanfc.filmesflix.data.MovieDataSource
import com.br.natanfc.filmesflix.domain.Movie
/*import com.br.natanfc.filmesflix.repository.MovieRepository*/

class MovieDataSoucesImplementation(private val movieRestApiTask: MovieRestApiTask):MovieDataSource {
    companion object{
        const val TAG="MovieRepository"
    }

    private val movieList= arrayListOf<Movie>()

    override fun getAllMovies(): List<Movie> {
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