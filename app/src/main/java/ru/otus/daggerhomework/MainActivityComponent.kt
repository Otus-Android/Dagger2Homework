package ru.otus.daggerhomework

import android.app.Activity
import android.content.Context
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Qualifier

@Component(
    dependencies = [
        ApplicationComponent::class
    ],
    modules = [
        MainActivityModule::class
    ]
)
@ActivityScope
interface MainActivityComponent {
    @ApplicationContext
    fun providesApplicationContext(): Context
    @ActivityContext
    fun providesActivityContext(): Context
    fun providesColorReceiver(): ColorReceiver
    fun providesColorProducer(): ColorProducer

    @Component.Factory
    interface Factory {
        fun create(
            applicationComponent: ApplicationComponent,
            @BindsInstance
            @ActivityContext
            activityContext: Context,
        ): MainActivityComponent
    }

    companion object {
        fun getMainActivityComponent(activity: Activity) =
            DaggerMainActivityComponent.factory()
                .create(
                    activity.application.getApplicationComponent(),
                    activity
                )
    }
}

@Module
class MainActivityModule {
    @ActivityScope
    @Provides
    fun providesColorProvider() = ColorProvider()

    @Provides
    fun providesColorReceiver(colorProvider: ColorProvider): ColorReceiver = colorProvider
    @Provides
    fun providesColorProducer(colorProvider: ColorProvider): ColorProducer = colorProvider
}

@Qualifier
annotation class ActivityContext
