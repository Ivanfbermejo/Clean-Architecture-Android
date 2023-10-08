package ivan.bermejo.view

import KoinDataBase
import android.app.Application
import ivan.bermejo.data.di.KoinRickAndMorty
import ivan.bermejo.view.di.KoinUseCase
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(arrayListOf(
                KoinRickAndMorty,
                KoinDataBase,
                KoinUseCase
            ))
        }

    }

}