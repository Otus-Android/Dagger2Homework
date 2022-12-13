package ru.otus.daggerhomework.components

import android.content.Context
import dagger.BindsInstance
import dagger.Subcomponent
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import ru.otus.daggerhomework.MainActivity
import ru.otus.daggerhomework.modules.ActivityComponentModule
import ru.otus.daggerhomework.scopes_and_qualifiers.ActivityContext
import ru.otus.daggerhomework.scopes_and_qualifiers.ActivityScope

@ActivityScope
@Subcomponent(modules = [ActivityComponentModule::class])
interface MainActivityComponent {

    @ActivityContext
    fun getActivityContext(): Context

    fun inject(mainActivity: MainActivity)

    fun getEventCache(): MutableStateFlow<Int>

    @Subcomponent.Factory
    interface Factory {
        fun create(
            @BindsInstance
            @ActivityContext
            context: Context): MainActivityComponent
    }
}