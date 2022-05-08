package ru.otus.daggerhomework

import android.app.Application
import android.content.Context
import androidx.lifecycle.ViewModelProvider
import dagger.*
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Singleton

@Singleton
@Component()
interface ApplicationComponent {

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance  @ApplicationContext context: Context
        ): ApplicationComponent
    }

    @ApplicationContext
    fun provideApplicationContext(): Context

}