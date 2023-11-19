package ru.otus.daggerhomework.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import kotlinx.coroutines.flow.MutableSharedFlow
import ru.otus.daggerhomework.*
import ru.otus.daggerhomework.di.qualifiers.ActivityQualifier
import ru.otus.daggerhomework.di.qualifiers.ApplicationQualifier
import ru.otus.daggerhomework.di.scopes.ActivityScope
import ru.otus.daggerhomework.ui.MainActivity

@ActivityScope
@Component(modules = [DataModule::class], dependencies = [ApplicationComponent::class])
interface MainActivityComponent {

    companion object {
        fun getMainActivityComponent(
            applicationComponent: ApplicationComponent,
            mainActivityContext: MainActivity
            ): MainActivityComponent {

            return DaggerMainActivityComponent.factory()
                        .create(applicationComponent, mainActivityContext)
        }
    }

    fun inject(mainActivity: MainActivity)

    fun getColorGenerator(): ColorGenerator

    fun getColorFlowMutable(): MutableSharedFlow<State>

    @ApplicationQualifier
    fun getApplicationContext(): Context

    @ActivityQualifier
    fun getMainActivityContext(): Context

    @Component.Factory
    interface Factory {
        fun create(
            applicationComponent: ApplicationComponent,

            @BindsInstance
            @ActivityQualifier
            mainActivityContext: Context

        ): MainActivityComponent
    }
}