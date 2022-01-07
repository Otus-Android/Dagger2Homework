package ru.otus.daggerhomework.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Named

@ActivityScope
@Component(dependencies = [ApplicationComponent::class], modules = [MainActivityModule::class])
interface MainActivityComponent {

  @Named("activity")
  fun provideActivityContext(): Context

  @Named("application")
  fun provideAppContext(): Context

  fun provideState(): MutableStateFlow<Int>

  @Component.Factory
  interface Factory {
    fun create(@Named("activity") @BindsInstance activityContext: Context,
               applicationComponent: ApplicationComponent): MainActivityComponent
  }

}


