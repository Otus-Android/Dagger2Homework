package ru.otus.daggerhomework.app.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.otus.daggerhomework.common.NeedInitializeException

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

        private var mInstance: ApplicationComponent? = null

        fun init(context: Context) {
            mInstance = DaggerApplicationComponent.factory()
                .create(context)
        }

        fun getInstance() = mInstance ?: throw NeedInitializeException()

    }

}