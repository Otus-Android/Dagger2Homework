package ru.otus.daggerhomework.di.component

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.otus.daggerhomework.FragmentReceiver
import ru.otus.daggerhomework.di.module.FragmentReceiverModule
import ru.otus.daggerhomework.di.scope.FragmentScope

@FragmentScope
@Component(modules = [FragmentReceiverModule::class], dependencies = [MainActivityComponent::class])
interface FragmentReceiverComponent {

    @Component.Factory
    interface Factory {
        fun create(mainActivityComponent: MainActivityComponent, @BindsInstance context: Context): FragmentReceiverComponent
    }

    fun inject(fragment: FragmentReceiver)
}