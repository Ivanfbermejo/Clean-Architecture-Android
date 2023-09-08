package ivan.bermejo.core.data.di

import androidx.room.Room
import ivan.bermejo.core.data.database.CharacterDatabase
import ivan.bermejo.core.data.database.dao.CharacterDao
import ivan.bermejo.core.data.network.ApiHelper
import ivan.bermejo.core.data.network.ApiService
import ivan.bermejo.core.data.network.IApiHelper
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val KoinModuleCore = module {
    single<Retrofit> {
        val okHttpClient = OkHttpClient.Builder()
            .readTimeout(10, TimeUnit.SECONDS)
            .connectTimeout(10, TimeUnit.SECONDS)
            .build()
        Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }
    fun createApiService(retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)
    single { createApiService(get()) }
    single<IApiHelper> { ApiHelper(get()) }

    single {
        Room.databaseBuilder(
            get(),
            CharacterDatabase::class.java,
            "rick_adn_morty"
        ).build()
    }
    single {
        get<CharacterDatabase>().getCharacterDao()
    }
}
