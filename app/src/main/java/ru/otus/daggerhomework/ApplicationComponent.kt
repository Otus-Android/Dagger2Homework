package ru.otus.daggerhomework

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.otus.daggerhomework.quilifiers.AppContext

@Component
interface ApplicationComponent {

    fun getMainActivityComponent(): MainActivityComponent.MainActivityComponentFactory

    @Component.Factory
    interface ApplicationComponentFactory {
        fun create(@BindsInstance @AppContext context: Context): ApplicationComponent
    }
}