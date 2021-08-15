package ru.otus.daggerhomework.components

import androidx.fragment.app.FragmentActivity
import dagger.BindsInstance
import dagger.Component
import ru.otus.daggerhomework.FragmentProducer
import ru.otus.daggerhomework.FragmentReceiver

@MainScope
@Component(modules = [MainModule::class, ViewModelModule::class], dependencies = [ApplicationComponent::class])
interface MainActivityComponent {

    fun inject(fragmentProduct: FragmentProducer)
    fun inject(fragmentReceiver: FragmentReceiver)

    @Component.Factory
    interface MainCompFactory {
        fun create(applicationComponent: ApplicationComponent, @BindsInstance activity: FragmentActivity): MainActivityComponent
    }
}