package ivan.bermejo.core.data.network

import kotlinx.coroutines.flow.flow

class ApiHelper(private var apiService: ApiService): IApiHelper {

    override fun getAllCharacter() = flow {
        emit(apiService.getAllCharacter().results)
    }

    override fun getAllLocation() = flow {
        emit(apiService.getAllLocation().results)
    }

    override fun getAllEpisode() = flow {
        emit(apiService.getAllEpisode().results)
    }
}