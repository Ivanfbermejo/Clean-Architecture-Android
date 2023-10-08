package ivan.bermejo.data.rickandmorty.network

import ivan.bermejo.data.rickandmorty.model.character.ResultsRickAndMorty
import retrofit2.http.GET

interface IDataRepository {
    @GET("character")
    suspend fun getResult(): ResultsRickAndMorty
}