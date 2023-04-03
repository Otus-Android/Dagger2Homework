package ru.otus.daggerhomework

import android.content.Context
import dagger.Binds
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.ReceiveChannel
import javax.inject.Qualifier
import javax.inject.Scope

@ActivityScope
@Component(
    dependencies = [ApplicationComponent::class],
    modules = [MainActivityModule::class]
)
interface MainActivityComponent {

    companion object {

        fun init(applicationComponent: ApplicationComponent, context: Context): MainActivityComponent {
            return DaggerMainActivityComponent.factory()
                .create(applicationComponent, context)
        }
    }

    @Component.Factory
    interface Factory {

        fun create(
            applicationComponent: ApplicationComponent,
            @BindsInstance @ActivityContext context: Context
        ): MainActivityComponent
    }

    fun inject(activity: MainActivity)

    @AppContext
    fun provideAppContext(): Context

    @ActivityContext
    fun provideActivityContext(): Context

    fun provideChannel(): Channel<Int>

    fun provideReceiveChannel(): ReceiveChannel<Int>
}

@Module
interface MainActivityModule {

    companion object {

        @Provides
        @ActivityScope
        fun provideChannel(): Channel<Int> = Channel()
    }

    @Binds
    @ActivityScope
    fun bindReceiveChannel(channel: Channel<Int>): ReceiveChannel<Int>
}

@Scope
annotation class ActivityScope

@Qualifier
annotation class ActivityContext