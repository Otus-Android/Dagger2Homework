package ru.otus.daggerhomework.di.component

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import dagger.*
import kotlinx.coroutines.flow.MutableSharedFlow
import ru.otus.daggerhomework.ColorGenerator
import ru.otus.daggerhomework.FragmentProducer
import ru.otus.daggerhomework.ViewModelProducer
import ru.otus.daggerhomework.di.scope.FragmentScope
import javax.inject.Qualifier

@FragmentScope
@Component(modules = [FragmentProducerModule::class], dependencies = [MainActivityComponent::class])
interface FragmentProducerComponent {

    @Component.Factory
    interface Factory {
        fun create(mainActivityComponent: MainActivityComponent, @BindsInstance context: Context): FragmentProducerComponent
    }

    fun inject(fragment: FragmentProducer)

    fun mainActivityComponent(mainActivityComponent: MainActivityComponent)
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