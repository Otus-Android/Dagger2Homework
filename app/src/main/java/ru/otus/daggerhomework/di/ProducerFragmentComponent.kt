package ru.otus.daggerhomework.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.otus.daggerhomework.ProducerViewModel

@Component(
    dependencies = [MainActivityComponent::class],
    modules = [ProducerModule::class]
)
@FragmentScope
interface ProducerFragmentComponent {

    @Component.Factory
    interface Factory {
        fun build(
            mainActivityComponent: MainActivityComponent,
            @BindsInstance context: Context
        ): ProducerFragmentComponent
    }

    fun viewModel(): ProducerViewModel

}