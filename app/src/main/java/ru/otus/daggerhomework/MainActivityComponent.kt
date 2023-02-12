package ru.otus.daggerhomework

import android.content.Context
import dagger.Binds
import dagger.BindsInstance
import dagger.Component
import dagger.Module

@ActivityScope
@Component(
    modules = [MainActivityModule::class],
    dependencies = [ApplicationComponent::class]
)
interface MainActivityComponent {

    @ActivityContext
    fun activityContext(): Context

    @ApplicationContext
    fun applicationContext(): Context

    fun colorRepository(): ColorRepository

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance
            @ActivityContext
            context: Context,
            appComponent: ApplicationComponent
        ): MainActivityComponent
    }
}

@Module
interface MainActivityModule {

    @Binds
    fun bindColorRepository(colorRepositoryImpl: ColorRepositoryImpl): ColorRepository

}