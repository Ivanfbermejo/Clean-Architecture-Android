package ivan.bermejo.core.data.network

import ivan.bermejo.core.data.model.Character
import ivan.bermejo.core.data.model.Episode
import ivan.bermejo.core.data.model.InputObjectCharacter
import ivan.bermejo.core.data.model.InputObjectEpisode
import ivan.bermejo.core.data.model.InputObjectLocation
import ivan.bermejo.core.data.model.Location
import retrofit2.http.GET

interface ApiService {

    @GET("character")
    suspend fun getAllCharacter(): InputObjectCharacter

    @GET("location")
    suspend fun getAllLocation(): InputObjectLocation

    @GET("episode")
    suspend fun getAllEpisode(): InputObjectEpisode
}