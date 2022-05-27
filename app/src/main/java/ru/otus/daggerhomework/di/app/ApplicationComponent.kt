package ru.otus.daggerhomework.di.app

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.otus.daggerhomework.MainActivity
import ru.otus.daggerhomework.di.qualifiers.AppContext
import javax.inject.Singleton

@Singleton
@Component
interface ApplicationComponent {

    fun inject(activity: MainActivity)

    @Component.Factory
    interface Factory {

        fun create(
            @AppContext
            @BindsInstance
            context: Context
        ): ApplicationComponent
    }
}