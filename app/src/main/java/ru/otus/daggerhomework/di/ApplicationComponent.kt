package ru.otus.daggerhomework

import android.app.Application
import android.app.Fragment
import android.content.Context

import dagger.*
import io.reactivex.rxjava3.subjects.PublishSubject
import javax.inject.Inject
import javax.inject.Singleton

@Component()
interface ApplicationComponent {
    @Component.Factory
    interface Factory {
        // With @BindsInstance, the Context passed in will be available in the graph
        fun create(
            @BindsInstance application: Application): ApplicationComponent
    }
    fun inject(application: App)
    fun provideApplication(): Application

}









