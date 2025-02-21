package ru.otus.daggerhomework.di.component

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import dagger.Provides
import ru.otus.daggerhomework.ProducerFragment
import ru.otus.daggerhomework.ProducerViewModel
import ru.otus.daggerhomework.di.module.ColorGeneratorModule
import ru.otus.daggerhomework.di.scope.FragmentScope
import javax.inject.Named

@FragmentScope
@Component(
    dependencies = [MainActivityComponent::class],
    modules = [ColorGeneratorModule::class]
)
interface ProducerFragmentComponent {


    @Component.Factory
    interface Factory {
        fun create(
            activityComponent: MainActivityComponent
        ): ProducerFragmentComponent
    }

    fun getProducerViewModel(): ProducerViewModel
    fun inject(producerFragment: ProducerFragment)

}