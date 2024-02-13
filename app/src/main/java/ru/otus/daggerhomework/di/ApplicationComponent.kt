package ru.otus.daggerhomework.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.otus.daggerhomework.GenerateModule
import javax.inject.Qualifier


@Component(
    modules = [
        GenerateModule::class
    ]
)
interface ApplicationComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance  @AppContext context: Context): ApplicationComponent
    }

    @AppContext
    fun provideContext(): Context


}
