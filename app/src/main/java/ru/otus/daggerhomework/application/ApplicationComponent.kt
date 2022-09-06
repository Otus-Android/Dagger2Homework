package ru.otus.daggerhomework.application

import android.app.Application
import com.stupkalex.rostok.di.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import ru.otus.daggerhomework.App
import ru.otus.daggerhomework.activity.MainActivityComponent
import ru.otus.daggerhomework.fragment.ColorModule

@ApplicationScope
@Component(modules = [ColorModule::class,ViewModelModule::class])
interface ApplicationComponent {

    fun inject(application: App)

    fun activityComponentFactory(): MainActivityComponent.Factory

    @Component.Factory
    interface Factory {

        fun create(
            @BindsInstance application: Application
        ): ApplicationComponent

    }
}