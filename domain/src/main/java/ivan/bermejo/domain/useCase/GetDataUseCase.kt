package ivan.bermejo.domain.useCase

import ivan.bermejo.domain.IDataRepository
import ivan.bermejo.domain.model.ViewData
import kotlinx.coroutines.flow.Flow

class GetDataUseCase(private val repository: IDataRepository) {
    suspend operator fun invoke(): List<ViewData> { return repository.getAll() }
}