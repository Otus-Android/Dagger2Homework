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
import ru.otus.daggerhomework.di.module.UseCaseModule
import ru.otus.daggerhomework.repository.ColorRepository
import ru.otus.daggerhomework.usecases.ProvideColorsUseCase
import ru.otus.daggerhomework.usecases.SetColorsUseCase

@Component(
    modules = [ColorRepositoryModule::class, UseCaseModule::class],
    dependencies = [ApplicationComponent::class]
)
@PerActivity
interface MainActivityComponent {

    @AppContext
    fun provideAppContext(): Context

    @ActivityContext
    fun provideActivityContext(): Context

    fun inject(mainActivity: MainActivity)

    fun provideRepository() : ColorRepository

    fun provideSetColorUseCase() : SetColorsUseCase
    fun provideColorUseCase() : ProvideColorsUseCase

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