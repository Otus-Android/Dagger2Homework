package ru.otus.daggerhomework

import android.app.Activity
import android.app.Application
import dagger.Binds
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Scope

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
    fun providesApplication(): Application
    fun providesActivity(): Activity
    fun providesColorProvider(): ColorProvider

    @Component.Factory
    interface Factory {
        fun create(
            applicationComponent: ApplicationComponent,
            @BindsInstance activity: Activity,
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
interface MainActivityModule {
    @ActivityScope
    @Binds
    fun bindColorProvider(@BindsInstance colorProvider: ColorProviderImpl): ColorProvider
}
