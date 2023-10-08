package ivan.bermejo.domain

import ivan.bermejo.domain.model.ViewData
import kotlinx.coroutines.flow.Flow

interface IRepositoryDataBase {
    val viewData: Flow<List<ViewData>>
    suspend fun insertAll(viewData: List<ViewData>)
    suspend fun count(): Int
    suspend fun update(viewData: ViewData)
}