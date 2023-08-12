package ru.otus.daggerhomework

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import javax.inject.Scope


@Component(dependencies = [ApplicationComponent::class])
@ActivityScope
interface MainActivityComponent {

    fun provideObserver(): CustomObserver

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationContext: Context, applicationComponent: ApplicationComponent): MainActivityComponent
    }

}

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class ActivityScope

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class FragmentScope