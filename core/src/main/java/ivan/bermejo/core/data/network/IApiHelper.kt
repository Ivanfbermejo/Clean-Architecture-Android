package ivan.bermejo.core.data.network

import ivan.bermejo.core.data.model.Character
import ivan.bermejo.core.data.model.Episode
import ivan.bermejo.core.data.model.Location
import kotlinx.coroutines.flow.Flow

interface IApiHelper {
    fun getAllCharacter(): Flow<List<Character>>
    fun getAllLocation(): Flow<List<Location>>
    fun getAllEpisode(): Flow<List<Episode>>
}