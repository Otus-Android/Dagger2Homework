package ru.otus.daggerhomework.activity

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import ru.otus.daggerhomework.applicaion.ApplicationComponent
import ru.otus.daggerhomework.producer.FragmentProducerComponent
import ru.otus.daggerhomework.receiver.FragmentReceiverComponent
import javax.inject.Named
import javax.inject.Scope

@MainActivityScope
@Component(
    modules = [MainActivityModule::class],
    dependencies = [ApplicationComponent::class]
)
interface ActivityComponent {

    @Component.Factory
    interface ActivityComponentFactory {
        fun create(
            @BindsInstance
            @Named("ActivityContext")
            context: Context,
            applicationComponent: ApplicationComponent
        ): ActivityComponent
    }

    fun plusProducerComponent(): FragmentProducerComponent
    fun plusReceiverComponent(): FragmentReceiverComponent
}

@Module
internal class MainActivityModule {

    private val colorsFlow = MutableSharedFlow<Int>(replay = 1)

    @Provides
    @MainActivityScope
    fun provideFlow(): SharedFlow<Int> = colorsFlow

    @Provides
    @MainActivityScope
    fun provideMutableFlow(): MutableSharedFlow<Int> = colorsFlow

}

@Scope
annotation class MainActivityScope