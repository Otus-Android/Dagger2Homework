package ru.otus.daggerhomework

import android.app.Application
import android.content.Context
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.*
import dagger.multibindings.IntoMap
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.*
import kotlin.reflect.KClass
@ActivityScope
@Component(modules = [ObserverModule::class], dependencies = [ApplicationComponent::class])
interface ActivityComponent{
    @Named("activity")
    fun provideContext(): Context
    fun provideAppContext(): Context
    fun provideObserver(): ColorObserver
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance @Named("activity") context: Context, app:ApplicationComponent): ActivityComponent;
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
class ColorObserverImpl @Inject constructor(): ColorObserver{
    override val state: MutableStateFlow<Int> = MutableStateFlow(0xFFFFFF)
}

@Scope
annotation class ActivityScope



