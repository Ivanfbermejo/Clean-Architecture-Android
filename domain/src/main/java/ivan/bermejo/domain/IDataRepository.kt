package ivan.bermejo.domain

import ivan.bermejo.domain.model.ViewData
import kotlinx.coroutines.flow.Flow

interface IDataRepository {
    suspend fun getAll(): List<ViewData>
}