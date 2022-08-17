package ru.otus.daggerhomework.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Component
import dagger.Module
import dagger.multibindings.IntoMap
import ru.otus.daggerhomework.generator.ColorGenerator
import ru.otus.daggerhomework.generator.ColorGeneratorImpl
import ru.otus.daggerhomework.screens.producer.FragmentProducer
import ru.otus.daggerhomework.screens.producer.ViewModelProducer
import ru.otus.daggerhomework.screens.receiver.FragmentReceiver
import ru.otus.daggerhomework.screens.receiver.ViewModelReceiver
import javax.inject.Scope

@FragmentScope
@Component(
    dependencies = [MainActivityComponent::class],
    modules = [FragmentReceiverModule::class]
)
interface FragmentReceiverComponent {

    fun inject(fragment: FragmentReceiver)

    @Component.Factory
    interface Factory {

        fun create(
            activityComponent: MainActivityComponent
        ): FragmentReceiverComponent
    }
}

@Module
interface FragmentReceiverModule {

    @Binds
    @IntoMap
    @ViewModelKey(ViewModelReceiver::class)
    fun getViewModelReceiver(viewModel: ViewModelReceiver): ViewModel
}


@FragmentScope
@Component(
    dependencies = [MainActivityComponent::class],
    modules = [FragmentProducerModule::class]
)
interface FragmentProducerComponent {

    fun inject(fragment: FragmentProducer)

    @Component.Factory
    interface Factory {

        fun create(
            activityComponent: MainActivityComponent
        ): FragmentProducerComponent
    }
}

@Module
interface FragmentProducerModule {

    @Binds
    fun bindColorGenerator(colorGeneratorImpl: ColorGeneratorImpl): ColorGenerator

    @Binds
    @IntoMap
    @ViewModelKey(ViewModelProducer::class)
    fun getViewModelProducer(viewModel: ViewModelProducer): ViewModel
}

@Scope
annotation class FragmentScope