package ru.otus.daggerhomework.di.activity

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.otus.daggerhomework.di.ActivityContext
import ru.otus.daggerhomework.di.ActivityScope
import ru.otus.daggerhomework.di.AppComponent
import ru.otus.daggerhomework.di.AppContext
import ru.otus.daggerhomework.presentation.viewmodels.ReceiveColorFlow
import ru.otus.daggerhomework.presentation.viewmodels.SentColor

@ActivityScope
@Component(
    modules = [ActivityModule::class],
    dependencies = [AppComponent::class]
)
interface ActivityComponent {

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance @ActivityContext context: Context,
            appComponent: AppComponent
        ): ActivityComponent
    }

    @ActivityContext
    fun provideContext(): Context

    @AppContext
    fun provideAppContext(): Context

    /**
     * Провайдит [SentColor] компонентам на уровень ниже
     */
    fun provideSentColor(): SentColor

    /**
     * Провайдит [ReceiveColorFlow] компонентам на уровень ниже
     */
    fun provideReceiveColor(): ReceiveColorFlow
}