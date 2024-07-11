package ru.otus.daggerhomework.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.otus.daggerhomework.ColorGenerator
import ru.otus.daggerhomework.ColorObserver
import ru.otus.daggerhomework.MainActivity
import javax.inject.Qualifier
import javax.inject.Scope

@ActivityScope
@Component(
    dependencies = [ApplicationComponent::class],
    modules = [ColorEventModule::class]
)
interface MainActivityComponent {

    @Component.Factory
    interface Factory {
        fun create(
            @ActivityContext @BindsInstance activityContext: Context,
            applicationComponent: ApplicationComponent
        ): MainActivityComponent
    }

    fun inject(activity: MainActivity)

    fun provideProducerComponent(): FragmentProducerComponent
    fun provideReceiverComponent(): FragmentReceiverComponent

    @ApplicationContext
    fun provideApplicationContext(): Context

    fun provideColorObserver(): ColorObserver

    fun provideColorGenerator(): ColorGenerator
}

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class ActivityScope

@Qualifier
annotation class ActivityContext