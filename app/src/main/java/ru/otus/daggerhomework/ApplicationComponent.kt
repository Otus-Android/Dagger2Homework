package ru.otus.daggerhomework

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import javax.inject.Qualifier
import javax.inject.Scope


@AppScope
@Component(
    modules = [AppModule::class],
)
interface ApplicationComponent {

    @Component.Factory
    interface Factory {
        fun create(@AppContext @BindsInstance context: Context): ApplicationComponent
    }

    @AppContext
    fun provideAppContext(): Context
}


sealed class Event {
    object Initial: Event()
    class ChangeColor(val color: Int): Event()
}

@Module
interface AppModule {

}


@Qualifier
annotation class AppContext

@Scope
annotation class AppScope