package ru.otus.daggerhomework

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import javax.inject.Named

@Component
interface ApplicationComponent {

    @Component.Factory
    interface ApplicationComponentFactory {
        fun create(@BindsInstance @Named("AppContext") context: Context): ApplicationComponent
    }
}