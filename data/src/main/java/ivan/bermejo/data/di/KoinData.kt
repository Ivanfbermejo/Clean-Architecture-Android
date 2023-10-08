package ivan.bermejo.data.di

import ivan.bermejo.data.rickandmorty.network.Repository
import ivan.bermejo.data.rickandmorty.network.IDataRepository
import ivan.bermejo.domain.IRepositoryApi
import okhttp3.OkHttpClient
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

enum class QualifierData {
    Data
}
val KoinRickAndMorty = module {
    val url = "https://rickandmortyapi.com/api/"

    single<IDataRepository>(named(QualifierData.Data)) {
        val okHttpClient = OkHttpClient.Builder()
            .readTimeout(10, TimeUnit.SECONDS)
            .connectTimeout(10, TimeUnit.SECONDS)
            .build()
        Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
            .create(IDataRepository::class.java)
    }

    single<IRepositoryApi>(named(QualifierData.Data)) { Repository(get(named(QualifierData.Data))) }
}