package ru.otus.daggerhomework

import android.content.Context
import androidx.lifecycle.ViewModel
import dagger.BindsInstance
import dagger.Component
import javax.inject.Qualifier
import javax.inject.Scope

@Component(dependencies = [ApplicationComponent::class],
    modules = [MainActivityModule::class]
)
@ActivityScope
interface MainActivityComponent {

    fun getMap(): Map<Class<*>, ViewModel>

    @Component.Factory
    interface Factory{
        fun create(
          @ActivityContext @BindsInstance context: Context,
            applicationComponent: ApplicationComponent
        ): MainActivityComponent
    }
}

@Qualifier
annotation class ActivityContext

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class ActivityScope