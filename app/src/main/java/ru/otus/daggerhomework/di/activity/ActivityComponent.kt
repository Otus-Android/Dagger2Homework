package ru.otus.daggerhomework.di.activity

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import kotlinx.coroutines.channels.Channel
import ru.otus.daggerhomework.ColorGenerator
import ru.otus.daggerhomework.LocalEvent
import ru.otus.daggerhomework.MainActivity
import ru.otus.daggerhomework.di.app.ApplicationComponent
import ru.otus.daggerhomework.di.app.ApplicationContextQualifier

@ActivityScope
@Component(
    modules = [ActivityModule::class],
    dependencies = [ApplicationComponent::class]
)
interface ActivityComponent {

    fun inject(activity: MainActivity)

    @ApplicationContextQualifier
    fun provideAppContext(): Context

    @ActivityContextQualifier
    fun provideActivityContext(): Context

    fun provideChannel(): Channel<LocalEvent>

    @Component.Factory
    interface ActivityComponentFactory {
        fun create(
            applicationComponent: ApplicationComponent,
            @BindsInstance
            @ActivityContextQualifier
            activityContext: Context
        ): ActivityComponent
    }
}
object ActivityComponentHolder {

    private var activityComponent: ActivityComponent? = null

    fun getActivityComponent(
        applicationComponent: ApplicationComponent,
        activityContext: Context
    ): ActivityComponent {
        return activityComponent ?: DaggerActivityComponent.factory()
            .create(applicationComponent, activityContext)
            .also {
                activityComponent = it
            }
    }
}