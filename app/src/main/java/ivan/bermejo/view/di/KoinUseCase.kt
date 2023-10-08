package ivan.bermejo.view.di

import ivan.bermejo.data.di.QualifierData
import ivan.bermejo.domain.useCase.GetDataUseCase
import org.koin.core.qualifier.named
import org.koin.dsl.module

val KoinUseCase = module {
    single { GetDataUseCase(get(named(QualifierData.Data)),get(named(QualifierDataBase.DataBase))) }
}