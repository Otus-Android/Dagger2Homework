package ru.otus.daggerhomework.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import javax.inject.Named
import javax.inject.Scope

@ActivityScope
@Component(dependencies = [ApplicationComponent::class])
interface MainActivityComponent {

    @Component.Factory
    interface Factory{
        fun create(
            @BindsInstance @Named("activityContext") context: Context,
            applicationComponent: ApplicationComponent
        ): MainActivityComponent
    }



}



@Scope
annotation class ActivityScope