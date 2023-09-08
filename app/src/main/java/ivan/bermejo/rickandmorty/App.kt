package ivan.bermejo.rickandmorty

import android.app.Application
import ivan.bermejo.core.data.di.KoinModuleCore
import ivan.bermejo.rickandmorty.di.KoinModuleView
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
                KoinModuleCore,
                KoinModuleView
            ))
        }

    }

}