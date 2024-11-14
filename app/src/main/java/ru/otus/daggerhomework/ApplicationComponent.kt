package ru.otus.daggerhomework

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import javax.inject.Qualifier
import javax.inject.Singleton

@Component
@Singleton
interface ApplicationComponent {

   @ApplicationContext
   fun provideContext(): Context

   @Component.Factory
   interface Factory{

      fun newAppComponent(@ApplicationContext @BindsInstance context: Context): ApplicationComponent
   }
}

@Qualifier
annotation class ApplicationContext