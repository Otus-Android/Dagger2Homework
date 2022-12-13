package ru.otus.daggerhomework.components

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.otus.daggerhomework.App
import ru.otus.daggerhomework.modules.SubComponentModule
import ru.otus.daggerhomework.scopes_and_qualifiers.AppContext
import javax.inject.Singleton

@Singleton
@Component(modules = [SubComponentModule::class])
interface ApplicationComponent {

    @AppContext
    fun getApplicationContext(): Context

    fun fragmentReceiverComponent(): FragmentReceiverComponent.Factory
    fun fragmentProducerComponent(): FragmentProducerComponent.Factory
    fun mainActivityComponent(): MainActivityComponent.Factory

    fun inject(app: App)

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance
                   @AppContext
                   context: Context): ApplicationComponent
    }
}