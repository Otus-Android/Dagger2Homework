package ru.otus.daggerhomework

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.channels.Channel
import javax.inject.Scope

@ActivityScope
@Component(
    modules = [MainActivityModule::class]
)
interface MainActivityComponent {

    companion object {

        fun init(context: Context): MainActivityComponent {
            return DaggerMainActivityComponent.factory()
                .create(context)
        }
    }

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance context: Context
        ): MainActivityComponent
    }

    fun inject(activity: MainActivity)

    fun provideContext(): Context

    fun provideChannel(): Channel<Int>
}

@Module
object MainActivityModule {

    @Provides
    @ActivityScope
    fun provideChannel(): Channel<Int> = Channel()
}

@Scope
annotation class ActivityScope