package ru.otus.daggerhomework.di.component

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.otus.daggerhomework.repository.ColorRepositoryImpl
import ru.otus.daggerhomework.MainActivity
import ru.otus.daggerhomework.di.ActivityContext
import ru.otus.daggerhomework.di.AppContext
import ru.otus.daggerhomework.di.PerActivity
import ru.otus.daggerhomework.di.module.ColorRepositoryModule

@Component(
    modules = [ColorRepositoryModule::class],
    dependencies = [ApplicationComponent::class]
)
@PerActivity
interface MainActivityComponent {

    @AppContext
    fun provideAppContext(): Context

    @ActivityContext
    fun provideActivityContext(): Context

    fun inject(mainActivity: MainActivity)

    fun provideRepository() : ColorRepositoryImpl

    companion object {
        fun create(
            @ActivityContext context: Context,
            appComponent: ApplicationComponent
        ): MainActivityComponent {
            return DaggerMainActivityComponent.factory().create(context, appComponent)
        }
    }

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance @ActivityContext context: Context,
            appComponent: ApplicationComponent
        ): MainActivityComponent
    }
}