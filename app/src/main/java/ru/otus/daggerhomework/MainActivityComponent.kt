package ru.otus.daggerhomework

import android.content.Context
import dagger.BindsInstance
import dagger.Component

@Component
interface MainActivityComponent {

  fun context(): Context

  fun inject(mainActivity: MainActivity)

  @Component.Factory
  interface Factory {
    fun create(@BindsInstance context: Context): MainActivityComponent
  }
}