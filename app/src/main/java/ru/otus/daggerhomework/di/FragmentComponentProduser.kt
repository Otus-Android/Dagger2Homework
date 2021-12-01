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
import ru.otus.daggerhomework.utils.ViewModelkey
import javax.inject.Named

@Module
interface FragmentProduserModule{
    @FragmentScope
    @Binds
    fun provideColorGenerator(colorGeneratorImpl: ColorGeneratorImpl): ColorGenerator
}

@FragmentScope
@Component(
    modules = [FragmentProduserModule::class],
    dependencies = [MainActivityComponent::class]
)
interface FragmentComponentProduser {
    fun inject(fragment:FragmentProducer)
    @Component.Factory
    interface Factory {
        fun create(applicationComponent: MainActivityComponent): FragmentComponentProduser
    }
}