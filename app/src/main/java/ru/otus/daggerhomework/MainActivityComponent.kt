package ru.otus.daggerhomework

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.channels.Channel
import ru.otus.daggerhomework.app.ApplicationComponent
import javax.inject.Named

@MainActivityScope
@Component(
    dependencies = [ApplicationComponent::class],
    modules = [MainActivityModule::class]
)
interface MainActivityComponent {

    @Named("app")
    fun provideAppContext(): Context

    @Named("act")
    fun provideActivityContext(): Context

    fun provideEventHandler(): Channel<Int>

    @Component.Factory
    interface Factory {

        fun create(
            appComponent: ApplicationComponent,
            @BindsInstance @Named("act") context: Context
        ): MainActivityComponent
    }
}

@Module
class MainActivityModule {

    @MainActivityScope
    @Provides
    fun provideEventHandler() = Channel<Int>()
}
