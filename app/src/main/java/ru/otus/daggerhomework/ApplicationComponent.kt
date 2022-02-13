package ru.otus.daggerhomework

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import io.reactivex.subjects.BehaviorSubject
import javax.inject.Named
import javax.inject.Scope

@Scope
annotation class AppScope

@Module
interface ApplicationModule {

}

@AppScope
@Component(
    modules = [
        ApplicationModule::class
    ]
)
interface ApplicationComponent {

    @Component.Factory
    interface Builder {
        fun create(@BindsInstance @Named("AppContext")context: Context): ApplicationComponent
    }

    @Named("AppContext")
    fun providesAppContext(): Context
}