package ru.otus.daggerhomework.di

import android.content.Context
import android.os.Build
import dagger.BindsInstance
import dagger.Component
import ru.otus.daggerhomework.App
import ru.otus.daggerhomework.MainActivity

@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    fun inject(app: App)

    @Component.Factory
    interface Factory {
        fun create(applicationModule: ApplicationModule): ApplicationComponent
    }

}