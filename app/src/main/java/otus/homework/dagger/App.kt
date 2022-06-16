package otus.homework.dagger

import android.app.Application
import otus.homework.dagger.di.*

class App : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent
                .factory()
            .create(applicationContext)
    }
}