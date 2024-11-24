package ru.otus.daggerhomework.di.activity

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.otus.daggerhomework.ColorState
import ru.otus.daggerhomework.di.application.ActivityScope
import ru.otus.daggerhomework.di.application.ApplicationComponent
import ru.otus.daggerhomework.di.application.ApplicationContext

@ActivityScope
@Component(
    modules = [ActivityModule::class],
    dependencies = [ApplicationComponent::class]
)
interface ActivityComponent {

    @ApplicationContext
    fun provideApplicationContext(): Context

    @ActivityContext
    fun provideActivityContext(): Context

    fun provideColorState(): ColorState

    @Component.Factory
    interface FactoryActivity {
        fun create(
            @BindsInstance @ActivityContext context: Context,
            applicationComponent: ApplicationComponent
        ): ActivityComponent
    }
}