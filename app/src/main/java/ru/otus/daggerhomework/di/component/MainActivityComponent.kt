package ru.otus.daggerhomework.di.component

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.flow.MutableSharedFlow
import ru.otus.daggerhomework.ColorGenerator
import ru.otus.daggerhomework.ColorGeneratorImpl
import ru.otus.daggerhomework.MainActivity
import javax.inject.Scope

@ActivityScope
@Component(modules = [MainActivityModule::class], dependencies = [ApplicationComponent::class])
interface MainActivityComponent {

    @Component.Factory
    interface Factory {
        fun create(applicationComponent: ApplicationComponent, @BindsInstance context: Context): MainActivityComponent
    }

    fun inject(activity: MainActivity)

    fun provideSharedFlow() : MutableSharedFlow<Int>

    fun provideColorGenerator() : ColorGenerator
}

@Module
class MainActivityModule {

    @ActivityScope
    @Provides
    fun provideSharedFlow(): MutableSharedFlow<Int> {
        return MutableSharedFlow()
    }

    @ActivityScope
    @Provides
    fun provideColorGenerator(): ColorGenerator {
        return ColorGeneratorImpl()
    }

    @ActivityScope
    @Provides
    fun getMainActivity(): MainActivity{
        return MainActivity()
    }
}

@Scope
@Retention(value = AnnotationRetention.RUNTIME)
annotation class ActivityScope