package ru.otus.daggerhomework

import android.app.Application
import android.content.Context
import dagger.Binds
import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Component(modules = [Fragments::class])
interface ApplicationComponent {
    fun inject(application: App)
}

@Module
abstract class Fragments {

    @Binds
    abstract fun bindFragmentProducer(appContext: Application): FragmentProducer


    @Binds
    abstract fun bindFragmentReceiver(appContext: Application): FragmentReceiver

    @Binds
    abstract fun bindViewModelProducer(appContext: Application): ViewModelProducer
}
