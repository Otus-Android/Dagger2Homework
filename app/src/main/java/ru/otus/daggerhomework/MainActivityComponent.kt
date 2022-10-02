package ru.otus.daggerhomework

import android.content.Context
import dagger.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Qualifier
import javax.inject.Scope

@MainActivityScope
@Component(
    modules = [MainActivityModule::class],
    dependencies = [ApplicationComponent::class],
)
interface MainActivityComponent {

    companion object {
        fun getMainActivityComponent(applicationComponent: ApplicationComponent, context: Context): MainActivityComponent {
            return DaggerMainActivityComponent.factory().create(applicationComponent, context)
        }
    }

    @Component.Factory
    interface Factory {
        fun create(applicationComponent: ApplicationComponent, @ActivityContext @BindsInstance context: Context): MainActivityComponent
    }

    fun inject(mainActivity: MainActivity)

    @ActivityContext
    fun provideActivityContext(): Context

    @AppContext
    fun provideAppContext(): Context

    @EventObserver
    fun provideEventObserver(): MutableStateFlow<Event>

    @EventObserverReceiver
    fun provideEventObserverReceiver(): StateFlow<Event>

}


@Module
interface MainActivityModule {
    companion object {
        @MainActivityScope
        @Provides
        @EventObserver
        fun provideEventObserver(): MutableStateFlow<Event> = MutableStateFlow(Event.Initial)

        @EventObserverReceiver
        @MainActivityScope
        @Provides
        fun provideEventObserverReceiver(@EventObserver eventObserver: MutableStateFlow<Event> ): StateFlow<Event> = eventObserver.asStateFlow()
    }
}

sealed class Event {
    object Initial: Event()
    class ChangeColor(val color: Int): Event()
}

@Scope
annotation class MainActivityScope

@Qualifier
annotation class ActivityContext

@Qualifier
annotation class EventObserver

@Qualifier
annotation class EventObserverReceiver
