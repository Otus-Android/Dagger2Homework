package ru.otus.daggerhomework.di.app

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.otus.daggerhomework.di.common.NeedInitializeException

@Component
interface ApplicationComponent {

    val applicationContext: Context

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance context: Context
        ): ApplicationComponent
    }

    companion object {

        var instance: ApplicationComponent? = null
            private set
            get() = field ?: throw NeedInitializeException()

        fun init(context: Context) {
            instance = DaggerApplicationComponent.factory()
                .create(context)
        }

    }

}