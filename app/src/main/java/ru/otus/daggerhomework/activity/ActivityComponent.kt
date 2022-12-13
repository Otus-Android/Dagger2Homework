package ru.otus.daggerhomework.activity

import android.content.Context
import dagger.*
import kotlinx.coroutines.flow.MutableSharedFlow
import ru.otus.daggerhomework.applicaion.ApplicationComponent
import ru.otus.daggerhomework.applicaion.ViewModelModule
import ru.otus.daggerhomework.producer.FragmentProducerComponent
import ru.otus.daggerhomework.receiver.FragmentReceiverComponent
import javax.inject.Named
import javax.inject.Scope

@MainActivityScope
@Component(
    modules = [MainActivityModule::class, ViewModelModule::class],
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
    @Provides
    @MainActivityScope
    fun provideFlow(): MutableSharedFlow<Int> = MutableSharedFlow(replay = 1)

}

@Scope
@Retention
annotation class MainActivityScope