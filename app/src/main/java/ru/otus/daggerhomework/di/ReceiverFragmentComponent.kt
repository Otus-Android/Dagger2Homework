package ru.otus.daggerhomework.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.otus.daggerhomework.ReceiverViewModel

@Component(
    dependencies = [MainActivityComponent::class],
    modules = [ReceiverModule::class]
)
@FragmentScope
interface ReceiverFragmentComponent {

    @Component.Factory
    interface Factory {
        fun build(
            mainActivityComponent: MainActivityComponent,
            @BindsInstance context: Context
        ): ReceiverFragmentComponent
    }

    fun viewModel(): ReceiverViewModel
}