package ru.otus.daggerhomework.di

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.multibindings.IntoMap
import ru.otus.daggerhomework.FragmentProducer
import ru.otus.daggerhomework.ViewModelProducer
import ru.otus.daggerhomework.ViewModleFactory
import ru.otus.daggerhomework.utils.FragmentScope
import ru.otus.daggerhomework.utils.ViewModelkey
import javax.inject.Named

@Module
interface FragmentProduserModule{
}

@FragmentScope
@Component(
    modules = [FragmentProduserModule::class],
    dependencies = [MainActivityComponent::class]
)
interface FragmentComponentProduser {
    fun getViewModule():ViewModleFactory
    @Component.Factory
    interface Factory {
        fun create(applicationComponent: MainActivityComponent): FragmentComponentProduser
    }
}