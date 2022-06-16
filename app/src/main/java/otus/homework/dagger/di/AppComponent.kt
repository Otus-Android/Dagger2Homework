package otus.homework.dagger.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import javax.inject.Qualifier

@AppScope
@Component
interface AppComponent {
    @AppScope
    fun applicationContext(): Context

    @Component.Factory
    interface Factory {
        fun create(@AppScope @BindsInstance appContext: Context): AppComponent
    }
}

@Qualifier
annotation class AppScope