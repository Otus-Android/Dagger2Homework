package ru.otus.daggerhomework.di

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import dagger.*
import dagger.multibindings.IntoMap
import ru.otus.daggerhomework.*
import ru.otus.daggerhomework.ui.FragmentProducer
import ru.otus.daggerhomework.ui.FragmentReceiver
import javax.inject.Qualifier
import javax.inject.Scope
import kotlin.reflect.KClass

@Qualifier
annotation class ActivityContext

@Scope
annotation class ActivityScope

@MapKey
annotation class FragmentKey(val value: KClass<out Fragment>)

@ActivityScope
@Component(
    modules = [MainActivityModule::class, FragmentBindingModule::class],
    dependencies = [ApplicationComponent::class]
)
interface MainActivityComponent {

    fun provideFragmentFactory(): FragmentFactory

    @Component.Factory
    interface Factory {
        fun create(
            @[BindsInstance ActivityContext] context: Context,
            component: ApplicationComponent
        ): MainActivityComponent
    }
}

@Module
interface MainActivityModule {

    @Binds
    @ActivityScope
    fun bindProducer(eventBus: EventBusImpl): EventBus

    @Binds
    fun bindGenerator(eventBus: ColorGeneratorImpl): ColorGenerator
}

@Module
abstract class FragmentBindingModule {

    @Binds
    @IntoMap
    @FragmentKey(FragmentProducer::class)
    abstract fun bindProducerFragment(producerFragment: FragmentProducer): Fragment

    @Binds
    @IntoMap
    @FragmentKey(FragmentReceiver::class)
    abstract fun bindReceiverFragment(consumerFragment: FragmentReceiver): Fragment

    @Binds
    abstract fun bindFragmentFactory(factory: DaggerFragmentFactory): FragmentFactory
}

