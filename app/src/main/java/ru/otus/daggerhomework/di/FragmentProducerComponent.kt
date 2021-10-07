package ru.otus.daggerhomework.di

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
import ru.otus.daggerhomework.ColorGenerator
import ru.otus.daggerhomework.ColorGeneratorImpl
import ru.otus.daggerhomework.FragmentProducer
import ru.otus.daggerhomework.ViewModelProducer
import javax.inject.Scope

@FragmentScope
@Component(modules = [FragmentProducerModule::class], dependencies = [MainActivityComponent::class])
interface FragmentProducerComponent {

    @Component.Factory
    interface Factory {

        fun create(
            mainActivityComponent: MainActivityComponent,
            @BindsInstance context: Context
        ): FragmentProducerComponent
    }

    companion object {

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
        @Provides
        fun provideColorGenerator(): ColorGenerator {
            return ColorGeneratorImpl()
        }
    }

    @FragmentScope
    @Binds
    fun bindProducerViewModelFactory(producerViewModelFactory: ViewModelProducer.ProducerViewModelFactory): ViewModelProvider.Factory

//    @FragmentScope
//    @Binds
//    fun bindColorGenerator(colorGenerator: ColorGeneratorImpl): ColorGenerator
}

@Scope
annotation class FragmentScope