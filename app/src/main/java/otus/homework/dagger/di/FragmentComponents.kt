package otus.homework.dagger.di

import dagger.Binds
import dagger.Component
import dagger.Module
import otus.homework.dagger.ColorGenerator
import otus.homework.dagger.ColorGeneratorImpl
import otus.homework.dagger.FragmentProducer
import otus.homework.dagger.FragmentReceiver
import javax.inject.Scope

@FragmentScope
@Component(dependencies = [AppComponent::class, ActivityComponent::class], modules = [FragmentReceiverModule::class])
interface FragmentReceiverComponent {

    fun inject(fragmentReceiver: FragmentReceiver)

    @Component.Factory
    interface Factory {
        fun create(
            appComponent: AppComponent,
            activityComponent: ActivityComponent
        ): FragmentReceiverComponent
    }
}

@Module
interface FragmentReceiverModule {

    @FragmentScope
    @Binds
    fun bindColorGenerator(colorGeneratorImpl: ColorGeneratorImpl): ColorGenerator
}

@FragmentScope
@Component(dependencies = [ActivityComponent::class], modules = [FragmentProducerModule::class])
interface FragmentProducerComponent {

    fun inject(fragmentProducer: FragmentProducer)

    @Component.Factory
    interface Factory {
        fun create(activityComponent: ActivityComponent): FragmentProducerComponent
    }
}

@Module
interface FragmentProducerModule {

    @FragmentScope
    @Binds
    fun bindColorGenerator(colorGeneratorImpl: ColorGeneratorImpl): ColorGenerator
}

@Scope
annotation class FragmentScope