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

    fun colorReceiver(): ColorReceiver

    fun colorProducer(): ColorProducer

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
    @ActivityScope
    fun bindColorRepository(colorRepositoryImpl: ColorRepositoryImpl): ColorReceiver

    @Binds
    @ActivityScope
    fun bindColorMutableRepository(colorRepositoryImpl: ColorRepositoryImpl): ColorProducer

}