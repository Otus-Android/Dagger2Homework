package ru.otus.daggerhomework.di

import android.content.Context
import dagger.*
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.*

@ActivityScope
@Component(modules = [ObserverModule::class], dependencies = [ApplicationComponent::class])
interface ActivityComponent{
    @Named("activity")
    fun provideContext(): Context
    fun provideAppContext(): Context
    fun provideObserver(): ColorObserver
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance @Named("activity") context: Context, app: ApplicationComponent): ActivityComponent;
    }
}

@Module
interface ObserverModule{
    @Binds
    @ActivityScope
    fun bindObserver(observer: ColorObserverImpl): ColorObserver
}

interface ColorObserver{
    val state: MutableStateFlow<Int>
}
class ColorObserverImpl @Inject constructor(): ColorObserver {
    override val state: MutableStateFlow<Int> = MutableStateFlow(0xFFFFFF)
}

@Scope
annotation class ActivityScope



