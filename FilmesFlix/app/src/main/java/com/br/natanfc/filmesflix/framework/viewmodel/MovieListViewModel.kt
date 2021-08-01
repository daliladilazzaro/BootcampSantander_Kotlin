package com.br.natanfc.filmesflix.framework.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.br.natanfc.filmesflix.presenter.MovieRestApiTask
import com.br.natanfc.filmesflix.data.MovieRepository
import com.br.natanfc.filmesflix.domain.Movie
import com.br.natanfc.filmesflix.implementations.MovieDataSoucesImplementation
/*import com.br.natanfc.filmesflix.repository.MovieRepository*/
import com.br.natanfc.filmesflix.usecase.MovieListUseCase

class MovieListViewModel:ViewModel() {

    private val movieRestApiTaks= MovieRestApiTask()
    private val movieDataSouces=MovieDataSoucesImplementation(movieRestApiTaks)
    private val movieRepository= MovieRepository(movieDataSouces)
    private val movieListCase=MovieListUseCase(movieRepository)

    companion object{
        const val TAG="MovieRepository"
    }

    private var _moviesList=MutableLiveData<List<Movie>>()
    val moviesList: LiveData<List<Movie>>
    get()=_moviesList

    fun init (){
        getAllMovies()
    }
    private fun getAllMovies(){
        Thread{
            try {
               // _moviesList.value=listOfMovie
                //_moviesList.postValue(movieRepository.getAllMovies())
                _moviesList.postValue(movieListCase.invoke())
            }catch (exception:Exception){
                Log.d(TAG, exception.message.toString())
            }
        }.start()

    }
}