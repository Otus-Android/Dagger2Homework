package ru.otus.daggerhomework.di.app

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import ru.otus.daggerhomework.di.activity.ActivityComponent
import ru.otus.daggerhomework.di.qualifiers.AppContext
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationComponentModule::class])
interface ApplicationComponent {

    fun provideActivityComponentFactory(): ActivityComponent.Factory

    @Component.Factory
    interface Factory {

        fun create(
            @AppContext
            @BindsInstance
            context: Context
        ): ApplicationComponent
    }
}

@Module(subcomponents = [ActivityComponent::class])
class ApplicationComponentModule