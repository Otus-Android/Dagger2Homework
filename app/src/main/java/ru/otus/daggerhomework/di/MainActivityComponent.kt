package ru.otus.daggerhomework.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.flow.MutableSharedFlow
import ru.otus.daggerhomework.App
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

    companion object {
        var mainActivityComponentInstance: MainActivityComponent? = null

        fun create(context: Context): MainActivityComponent {
            return if (mainActivityComponentInstance == null){
                mainActivityComponentInstance = DaggerMainActivityComponent.factory()
                    .create((context.applicationContext as App).applicationComponent, context)
                mainActivityComponentInstance!!
            } else
                mainActivityComponentInstance!!
        }
    }
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
}

@Scope
@Retention(value = AnnotationRetention.RUNTIME)
annotation class ActivityScope