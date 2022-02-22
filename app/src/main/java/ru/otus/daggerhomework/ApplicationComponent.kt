package ru.otus.daggerhomework

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import java.lang.ref.WeakReference
import javax.inject.Qualifier

@Component
interface ApplicationComponent {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance @Application applicationContext: WeakReference<Context>): ApplicationComponent
    }
    @Application
    fun provideContext(): WeakReference<Context>
}

@Qualifier
annotation class Application