package ru.otus.daggerhomework

import android.content.Context
import dagger.Module
import dagger.Binds
import dagger.BindsInstance
import dagger.Component
import dagger.Provides
import dagger.Subcomponent

@Component
interface ApplicationComponent {
    fun createFragmentProducerComponent() : FragmentProducerComponent
    fun createFragmentReceiverComponent() : FragmentReceiverComponent

    @Component.Factory
    interface ApplicationComponentFactory {
        fun create(@BindsInstance context : Context) : ApplicationComponent
    }
}

@Subcomponent(modules = [FragmentProducerModule::class])
interface FragmentProducerComponent {
    fun inject(fragment : FragmentProducer)
}

@Subcomponent(modules = [FragmentReceiverModule::class])
interface FragmentReceiverComponent {
    fun inject(fragment : FragmentReceiver)
}

@Module
interface FragmentProducerModule {

    companion object {
        @Provides
        fun provideColorContainer() : ColorContainer = ColorContainerImpl()

        @Provides
        fun provideColorGenerator() : ColorGenerator = ColorGeneratorImpl()
    }
}

@Module
interface FragmentReceiverModule {

    companion object {
        @Provides
        fun provideColorContainer(): ColorContainer = ColorContainerImpl()
    }
}
