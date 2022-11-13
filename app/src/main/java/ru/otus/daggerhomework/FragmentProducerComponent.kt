package ru.otus.daggerhomework

import android.content.Context
import dagger.Binds
import dagger.Component
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Scope

@FragmentScope
@Component(
    dependencies = [MainActivityComponent::class],
    modules = [FragmentProducerModule::class],
)
interface FragmentProducerComponent {

    fun inject(fragment: FragmentProducer)
}

@Module
interface FragmentProducerModule {

    companion object {

        @FragmentScope
        @Provides
        fun provideViewModel(
            colorGenerator: ColorGenerator,
            colorFlow: MutableStateFlow<Int?>,
            @ActivityContext context: Context,
        ): ViewModelProducer = ViewModelProducer(colorGenerator, colorFlow, context)
    }

    @FragmentScope
    @Binds
    fun bindColorGenerator(colorGenerator: ColorGeneratorImpl): ColorGenerator
}

@Scope
annotation class FragmentScope