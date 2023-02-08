package ru.otus.daggerhomework

import android.content.Context
import dagger.BindsInstance
import dagger.Component

@Component
@PerMainActivity
interface MainActivityComponent {

  @ActivityContext
  fun context(): Context

  fun inject(mainActivity: MainActivity)

  @Component.Factory
  interface Factory {
    fun create(
      @BindsInstance
      @ActivityContext
      context: Context
    ): MainActivityComponent
  }
}