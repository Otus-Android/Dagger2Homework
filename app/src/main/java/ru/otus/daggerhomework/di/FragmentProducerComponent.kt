package ru.otus.daggerhomework.di

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import dagger.*
import kotlinx.coroutines.flow.MutableSharedFlow
import ru.otus.daggerhomework.ColorGenerator
import ru.otus.daggerhomework.FragmentProducer
import ru.otus.daggerhomework.ViewModelProducer
import javax.inject.Qualifier
import javax.inject.Scope

@FragmentScope
@Component(modules = [FragmentProducerModule::class], dependencies = [MainActivityComponent::class])
interface FragmentProducerComponent {

    @Component.Factory
    interface Factory {
        fun create(mainActivityComponent: MainActivityComponent, @BindsInstance context: Context): FragmentProducerComponent
    }

    companion object{
        fun create(context: Context): FragmentProducerComponent {
            return DaggerFragmentProducerComponent.factory()
                .create(MainActivityComponent.create(context), context)
        }
    }

    fun inject(fragment: FragmentProducer)
}

@Module
interface FragmentProducerModule {

    companion object {
        @FragmentScope
        @ProducerViewModel
        @Provides
        fun provideViewModelProducer (colorGenerator: ColorGenerator, context: Context, mutableSharedFlow: MutableSharedFlow<Int>): ViewModelProducer {
            return ViewModelProducer(colorGenerator, context, mutableSharedFlow)
        }
    }

    @FragmentScope
    @ProducerViewModel
    @Binds
    fun bindProducerViewModelFactory(producerViewModelFactory: ViewModelProducer.ProducerViewModelFactory): ViewModelProvider.Factory
}

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class ProducerViewModel

@Scope
@Retention(value = AnnotationRetention.RUNTIME)
annotation class FragmentScope