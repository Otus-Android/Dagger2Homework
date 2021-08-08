package ru.otus.daggerhomework.di

import android.content.Context
import dagger.Binds
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import ru.otus.daggerhomework.App
import ru.otus.daggerhomework.FlowObserver
import ru.otus.daggerhomework.IntFlowObserver

/**
 * @author Юрий Польщиков on 08.08.2021
 */
@Component(
    modules = [MainActivityModule::class],
    dependencies = [ApplicationComponent::class]
)
@ActivityScope
interface MainActivityComponent {

    @AppContext
    fun getAppContext(): Context

    @ActivityContext
    fun getActivityContext(): Context

    fun getFlowObserver(): FlowObserver<Int>

    @Component.Factory
    interface Factory {

        fun create(
            @[BindsInstance ActivityContext] context: Context,
            applicationComponent: ApplicationComponent
        ): MainActivityComponent
    }

    companion object {
        fun create(@ActivityContext context: Context): MainActivityComponent {
            return DaggerMainActivityComponent.factory()
                .create(
                    context,
                    (context.applicationContext as App).getAppComponent()
                )
        }
    }
}

interface MainActivityComponentProvider {

    fun getMainActivityComponent(): MainActivityComponent
}

@Module
interface MainActivityModule {

    @Binds
    @ActivityScope
    fun provideFlowObserver(intFlowObserver: IntFlowObserver): FlowObserver<Int>
}
