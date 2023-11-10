package ru.otus.daggerhomework

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import javax.inject.Qualifier
import javax.inject.Scope

@MainActivityScope
@Component(dependencies = [ApplicationComponent::class], modules = [MainActivityModule::class])
interface MainActivityComponent {

    fun inject(mainActivity: MainActivity)

    @AppContext
    fun appContext(): Context

    @MainActivityContext
    fun activityContext(): Context

    @Component.Factory
    interface Factory {
        fun create(
            applicationComponent: ApplicationComponent,
            @BindsInstance @MainActivityContext context: Context
        ): MainActivityComponent
    }
}



@Module
interface MainActivityModule {

}

@Qualifier
annotation class MainActivityContext

@Scope
annotation class MainActivityScope
