package ivan.bermejo.database.network

import ivan.bermejo.core.data.database.Database
import ivan.bermejo.database.entities.toDataEntity
import ivan.bermejo.database.entities.toViewData
import ivan.bermejo.domain.IRepositoryDataBase
import ivan.bermejo.domain.model.ViewData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class Repository(private var database: Database): IRepositoryDataBase {
    override val viewData: Flow<List<ViewData>> = database.getDao().getAll().map { dataEntity -> dataEntity.map { it.toViewData() } }
    override suspend fun insertAll(viewData: List<ViewData>) = database.getDao().insertAll(viewData.map { it.toDataEntity() })
    override suspend fun count(): Int = database.getDao().count()
    override suspend fun update(viewData: ViewData) = database.getDao().update(viewData.toDataEntity())

}