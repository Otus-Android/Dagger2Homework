package ru.otus.daggerhomework.di

import android.content.Context
import dagger.Binds
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import ru.otus.daggerhomework.utils.ColorChangeObserver
import ru.otus.daggerhomework.utils.ColorChangeObserverImpl
import ru.otus.daggerhomework.utils.ColorGenerator
import ru.otus.daggerhomework.utils.ColorGeneratorImpl

@ActivityScope
@Component(
    modules = [MainActivityModule::class],
    dependencies = [ApplicationComponent::class]
)
interface MainActivityComponent : DaggerComponent {

    fun provideContext(): Context

    @AppContext
    fun provideAppContext(): Context

    fun provideColorGenerator(): ColorGenerator

    fun provideColorChangeObserver(): ColorChangeObserver

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance
            context: Context,
            appComponent: ApplicationComponent,
        ): MainActivityComponent
    }
}

@Module
interface MainActivityModule {
    @Binds
    fun bindColorGenerator(impl: ColorGeneratorImpl): ColorGenerator

    @ActivityScope
    @Binds
    fun bindColorChangeObserver(impl: ColorChangeObserverImpl): ColorChangeObserver
}