package ivan.bermejo.domain

import ivan.bermejo.domain.model.ViewData

interface IRepositoryApi {
    suspend fun getAll(): List<ViewData>
}