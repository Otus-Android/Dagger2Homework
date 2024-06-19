package ru.otus.daggerhomework

import android.content.Context
import dagger.Binds
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import javax.inject.Qualifier
import javax.inject.Scope

@Scope
annotation class ActivityScope

@Qualifier
annotation class ContextActivity

@ActivityScope
@Component(
  modules = [MainActivityModule::class],
  dependencies = [ApplicationComponent::class],
)
interface MainActivityComponent {

  @Component.Factory
  interface Factory {
    fun create(
      applicationComponent: ApplicationComponent,
      @BindsInstance @ContextActivity context: Context,
    ): MainActivityComponent
  }

  @ContextApplication
  fun provideApplicationContext(): Context

  @ContextActivity
  fun provideActivityContext(): Context

  fun provideObservable(): IColorObservable

  fun inject(mainActivity: MainActivity)
}

@Module
interface MainActivityModule {
  @ActivityScope
  @Binds
  fun bindObservable(impl: ColorObservableImpl): IColorObservable
}