package ru.otus.daggerhomework.activity

import android.app.Activity
import androidx.fragment.app.FragmentActivity
import dagger.BindsInstance
import dagger.Component
import dagger.Subcomponent
import kotlinx.coroutines.flow.MutableStateFlow
import ru.otus.daggerhomework.MainActivity
import ru.otus.daggerhomework.fragment.ColorModule
import ru.otus.daggerhomework.fragment.FragmentProducerComponent
import ru.otus.daggerhomework.fragment.FragmentReceiverComponent

@ActivityScope
@Subcomponent(modules = [ActivityModule::class])
interface MainActivityComponent {

    fun inject(activity: MainActivity)

    fun getStateFlow(): MutableStateFlow<Int>

    fun fragmentProducerComponentFactory(): FragmentProducerComponent.Factory

    fun fragmentReceiverComponentFactory(): FragmentReceiverComponent.Factory

    @Subcomponent.Factory
    interface Factory {

        fun create(
            @BindsInstance context: FragmentActivity
        ): MainActivityComponent

    }
}