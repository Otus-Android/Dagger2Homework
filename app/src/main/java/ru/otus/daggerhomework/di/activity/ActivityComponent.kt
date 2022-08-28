package ru.otus.daggerhomework.di.activity

import android.content.Context
import dagger.BindsInstance
import dagger.Subcomponent
import kotlinx.coroutines.flow.MutableStateFlow
import ru.otus.daggerhomework.MainActivity
import ru.otus.daggerhomework.di.fragment.FragmentProducerComponent
import ru.otus.daggerhomework.di.fragment.FragmentReceiverComponent
import ru.otus.daggerhomework.di.quialifiers.ActivityContext
import javax.inject.Singleton

@Singleton
@Subcomponent(modules = [ActivityModule::class])
interface ActivityComponent {

  fun getStateFlow(): MutableStateFlow<Int>

  fun fragmentProducerComponentFactory(): FragmentProducerComponent.Factory

  fun fragmentReceiverComponentFactory(): FragmentReceiverComponent.Factory

  fun inject(mainActivity: MainActivity)

  @Subcomponent.Factory
  interface Factory {
    fun create(@BindsInstance @ActivityContext context: Context): ActivityComponent
  }
}