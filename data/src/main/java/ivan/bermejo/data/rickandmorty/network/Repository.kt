package ivan.bermejo.data.rickandmorty.network

import ivan.bermejo.data.rickandmorty.model.character.toViewData
import ivan.bermejo.domain.IRepositoryApi
import ivan.bermejo.domain.model.ViewData

class Repository(private var apiService: IDataRepository): IRepositoryApi {
    override suspend fun getAll(): List<ViewData> = apiService.getResult().results.map { it.toViewData() }
}