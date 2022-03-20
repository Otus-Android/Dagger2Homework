package ru.otus.daggerhomework

import android.app.Application
import dagger.*

@Component
interface ApplicationComponent {
    @Component.Factory
    interface Factory {
        // With @BindsInstance, the Context passed in will be available in the graph
        fun create(
            @BindsInstance application: Application
        ): ApplicationComponent
    }

    fun inject(application: App)
    fun provideApplication(): Application

}









