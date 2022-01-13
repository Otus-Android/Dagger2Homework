package ru.otus.daggerhomework.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import kotlinx.coroutines.channels.Channel
import ru.otus.daggerhomework.MainActivity
import ru.otus.daggerhomework.Result

@Component(modules = [MainActivityModule::class], dependencies = [ApplicationComponent::class])
@ActivityScope
interface MainActivityComponent {
    fun activityContext(): Context

    @ApplicationContext
    fun applicationContext(): Context

    fun observer(): Channel<Result>

    fun receiverComponent(): FragmentReceiverComponent.Factory
    fun producerComponent(): FragmentProducerComponent.Factory
    fun inject(mainActivity: MainActivity)

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance activityContext: Context,
            applicationComponent: ApplicationComponent
        ): MainActivityComponent
    }
}
