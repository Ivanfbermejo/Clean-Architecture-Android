import androidx.room.Room
import ivan.bermejo.core.data.database.Database
import ivan.bermejo.database.network.Repository
import ivan.bermejo.domain.IRepositoryApi
import ivan.bermejo.domain.IRepositoryDataBase
import org.koin.core.qualifier.named
import org.koin.dsl.module

enum class QualifierDataBase {
    DataBase
}
val KoinDataBase = module {
    val name = "rick_adn_morty"

    single(named(QualifierDataBase.DataBase)) {
        Room.databaseBuilder(
            get(),
            Database::class.java,
            name
        ).build()
    }
    single(named(QualifierDataBase.DataBase)) {
        get<Database>(named(QualifierDataBase.DataBase)).getDao()
    }
    single<IRepositoryDataBase>(named(QualifierDataBase.DataBase)) {
        Repository(get(named(QualifierDataBase.DataBase)))
    }
}