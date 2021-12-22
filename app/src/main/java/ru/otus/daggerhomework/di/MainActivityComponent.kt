package ru.otus.daggerhomework.di

import android.content.Context
import dagger.*
import ru.otus.daggerhomework.Transceiver

@ActivityScope
@Component
interface MainActivityComponent {

    fun provideActivityContext(): Context
    fun provideTransceiver(): Transceiver

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): MainActivityComponent
    }
}