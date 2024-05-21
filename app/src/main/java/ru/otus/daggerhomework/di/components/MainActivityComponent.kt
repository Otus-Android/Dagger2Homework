package ru.otus.daggerhomework.di.components

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.otus.daggerhomework.di.annotations.AppContext
import ru.otus.daggerhomework.di.annotations.MainActivityScope
import ru.otus.daggerhomework.di.modules.ActivityModule
import ru.otus.daggerhomework.ui.producer.ViewModelProducer
import ru.otus.daggerhomework.ui.receiver.ViewModelReceiver

@MainActivityScope
@Component(
    dependencies = [ApplicationComponent::class],
    modules = [ActivityModule::class]
)
interface MainActivityComponent {
    fun provideViewModelProducer(): ViewModelProducer
    fun provideViewModelReceiver(): ViewModelReceiver

    @AppContext
    fun provideApplicationContext(): Context

    fun provideActivityContext(): Context

    @Component.Factory
    interface Factory {
        fun create(
            applicationComponent: ApplicationComponent,
            @BindsInstance context: Context
        ): MainActivityComponent
    }
}