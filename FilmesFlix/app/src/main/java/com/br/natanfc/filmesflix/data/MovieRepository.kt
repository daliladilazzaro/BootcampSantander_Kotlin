package com.br.natanfc.filmesflix.data

class MovieRepository(private val movieDataSouces:MovieDataSource) {
    fun getAllMoviesFromDataSouces()=movieDataSouces.getAllMovies()
}