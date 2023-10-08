package ivan.bermejo.domain.useCase

import ivan.bermejo.domain.IRepositoryDataBase
import ivan.bermejo.domain.IRepositoryApi
import ivan.bermejo.domain.model.ViewData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.count

class GetDataUseCase(private val repository: IRepositoryApi, private val database: IRepositoryDataBase) {

    val viewData: Flow<List<ViewData>> = database.viewData
    suspend fun requestViewData() {
        val isDbEmpty = database.count() == 0
        if (isDbEmpty) {
            database.insertAll(repository.getAll())
        }
    }

    suspend fun updateViewData(viewData: ViewData){
        database.update(viewData.copy(favorite = !viewData.favorite))
    }
}