package ru.otus.daggerhomework

import android.content.Context
import dagger.*
import kotlinx.coroutines.flow.MutableStateFlow

@Component(
    modules = [ViewModelProducerModule::class],
    dependencies = [ApplicationComponent::class, MainActivityComponent::class]
)
interface FragmentProducerComponent {

    fun inject(fragmentProducer: FragmentProducer)
}

@Module
object ViewModelProducerModule {

    @Provides
    fun provide(colorGenerator: ColorGenerator, context: Context, flow: MutableStateFlow<Int>): ViewModelProducer {
        return ViewModelProducer(colorGenerator, context, flow)
    }
}