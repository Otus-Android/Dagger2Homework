package ru.otus.daggerhomework

import android.app.Application
import android.content.Context
import androidx.lifecycle.ViewModelProvider
import dagger.*
import javax.inject.Singleton

@Singleton
@Component(modules = [ColorGeneratorModule::class,FragmentModule::class])
interface ApplicationComponent {
    @Component.Factory
    interface Factory {
        // With @BindsInstance, the Context passed in will be available in the graph
        fun create(
            @BindsInstance context: Context,
            @BindsInstance application: Application): ApplicationComponent
    }
    fun inject(mainActivity: MainActivity?)
}


@Module
class AppModule(private val mApp:App) {


    @Provides
    @Singleton
    fun provideApplication(): Application {
        return mApp
    }

    @Provides
    @Singleton
    fun provideContext(): Context {
        return mApp.applicationContext
    }
}




