package ru.otus.daggerhomework.di

import android.content.Context
import dagger.Binds
import dagger.Component
import dagger.Module
import dagger.Provides
import dagger.Reusable
import ru.otus.daggerhomework.ColorGenerator
import ru.otus.daggerhomework.ColorGeneratorImpl
import ru.otus.daggerhomework.FlowObserver
import ru.otus.daggerhomework.ViewModelProducerFactory

/**
 * @author Юрий Польщиков on 08.08.2021
 */
@Component(
    modules = [FragmentProducerModule::class],
    dependencies = [
        MainActivityComponent::class
    ]
)
@FragmentScope
interface FragmentProducerComponent {

    fun getViewModelProducerFactory(): ViewModelProducerFactory

    @Component.Factory
    interface Factory {

        fun create(
            mainActivityComponent: MainActivityComponent
        ): FragmentProducerComponent
    }

    companion object {
        fun create(@ActivityContext context: Context): FragmentProducerComponent {
            return DaggerFragmentProducerComponent.factory()
                .create(
                    (context as MainActivityComponentProvider).getMainActivityComponent()
                )
        }
    }
}

@Module
interface FragmentProducerModule {

    @Binds
    @Reusable
    fun provideColorGenerator(colorGenerator: ColorGeneratorImpl): ColorGenerator

    companion object {

        @Provides
        fun provideViewModelProducerFactory(
            colorGenerator: ColorGenerator,
            flowObserver: FlowObserver<Int>,
            @ActivityContext context: Context
        ) = ViewModelProducerFactory(colorGenerator, flowObserver, context)
    }
}
