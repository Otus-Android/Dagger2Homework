package ru.otus.daggerhomework.di.components

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.otus.daggerhomework.ViewModelProducer
import ru.otus.daggerhomework.ViewModelReceiver
import ru.otus.daggerhomework.di.modules.ActivityModule
import ru.otus.daggerhomework.di.qualifiers.ActivityContext
import ru.otus.daggerhomework.di.qualifiers.AppContext
import ru.otus.daggerhomework.di.scopes.MainActivityScope

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

    @ActivityContext
    fun provideActivityContext(): Context

    @Component.Factory
    interface Factory {
        fun create(applicationComponent: ApplicationComponent,
                   @BindsInstance @ActivityContext context: Context): MainActivityComponent
    }
}