package ru.otus.daggerhomework.di.main

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import kotlinx.coroutines.channels.Channel
import ru.otus.daggerhomework.App
import ru.otus.daggerhomework.di.ApplicationComponent
import ru.otus.daggerhomework.di.utils.qualifiers.ActivityContext
import ru.otus.daggerhomework.di.utils.qualifiers.ApplicationContext
import ru.otus.daggerhomework.di.utils.scopes.ActivityScope
import ru.otus.daggerhomework.presentation.Activity
import ru.otus.daggerhomework.presentation.color.ColorGenerator

/**
 * `Dagger` [Component] главного экрана
 */
@ActivityScope
@Component(
    modules = [MainActivityModule::class],
    dependencies = [ApplicationComponent::class]
)
interface MainActivityComponent {

    /** `Application` контекст */
    @get:ApplicationContext
    val appContext: Context

    /** `Activity` контекст */
    @get:ActivityContext
    val activityContext: Context

    /** Генератор цветов */
    val colorGenerator: ColorGenerator

    /** Канал числовых значений в виде [Int] */
    val channel: Channel<Int>

    @Component.Factory
    interface Factory {
        fun create(
            component: ApplicationComponent,
            @BindsInstance @ActivityContext context: Context
        ): MainActivityComponent
    }

    companion object {

        /** Создать `Dagger` [Component] главного экрана на основе соответствующей [Activity] */
        fun create(activity: Activity): MainActivityComponent =
            DaggerMainActivityComponent.factory()
                .create(
                    component = App.appComponent(activity.applicationContext),
                    context = activity
                )
    }
}