package ru.otus.daggerhomework.di

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.multibindings.IntoMap
import kotlinx.coroutines.flow.MutableStateFlow
import ru.otus.daggerhomework.*
import ru.otus.daggerhomework.utils.FragmentScope

import javax.inject.Named


@FragmentScope
@Component(
    dependencies = [MainActivityComponent::class]
)
interface FragmentComponentReceiver {
    fun inject(fragment: FragmentReceiver)
    @Component.Factory
    interface Factory {
        fun create(applicationComponent: MainActivityComponent): FragmentComponentReceiver
    }
}