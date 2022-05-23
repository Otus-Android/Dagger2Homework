package ru.otus.daggerhomework.app.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.otus.daggerhomework.common.NeedInitializeException
import ru.otus.daggerhomework.main.impl.di.MainActivityComponent
import ru.otus.daggerhomework.producer.di.FragmentProducerComponent
import ru.otus.daggerhomework.receiver.di.FragmentReceiverComponent

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
            MainActivityComponent.init { getInstance().applicationContext }
            FragmentProducerComponent.init { MainActivityComponent.getInstance() }
            FragmentReceiverComponent.init { MainActivityComponent.getInstance() }
        }

        fun getInstance() = mInstance ?: throw NeedInitializeException()

    }

}