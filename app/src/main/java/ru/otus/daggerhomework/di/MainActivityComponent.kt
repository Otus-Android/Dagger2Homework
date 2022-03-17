package ru.otus.daggerhomework.di

import android.app.Application
import android.content.Context
import dagger.BindsInstance
import dagger.Component
import io.reactivex.rxjava3.subjects.PublishSubject
import ru.otus.daggerhomework.*
import javax.inject.Scope
import javax.inject.Singleton

@Singleton
@Component(modules = [ ObserverModule::class,ColorGeneratorModule::class],
    dependencies = [ApplicationComponent::class])
interface MainActivityComponent  {

    @Component.Factory
    interface Factory {
        // With @BindsInstance, the Context passed in will be available in the graph
        fun create(
            applicationComponent: ApplicationComponent,
            @BindsInstance context: Context
        ): MainActivityComponent
    }

    fun inject(mainActivity: MainActivity)

    fun provideApplication(): Application

    fun provideContext(): Context

    fun provideObserver(): PublishSubject<Int>

    fun provideColorGenerator(): ColorGenerator


}

@Scope
annotation class ActivityScope