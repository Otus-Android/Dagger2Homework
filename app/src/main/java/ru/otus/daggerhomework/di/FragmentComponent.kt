package ru.otus.daggerhomework.di

import dagger.Component
import dagger.Module
import dagger.Provides
import ru.otus.daggerhomework.*
import javax.inject.Scope

@FragmentScope
@Component(modules = [FragmentsModule::class],
    dependencies = [MainActivityComponent::class])
interface FragmentComponent {
    fun inject(mainActivity: MainActivity)
}

@Module
class FragmentsModule {

    @Provides
    fun provideFragmentReceiver(): FragmentReceiver {
        return FragmentReceiver()
    }

    @Provides
    fun provideFragmentProducer(): FragmentProducer {
        return FragmentProducer()
    }
}

@Scope
annotation class FragmentScope