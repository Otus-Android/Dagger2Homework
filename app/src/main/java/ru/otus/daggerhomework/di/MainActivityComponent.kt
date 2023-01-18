package ru.otus.daggerhomework.di

import dagger.Component
import ru.otus.daggerhomework.MainActivity

@Component(modules = [MainActivityModule::class])
interface MainActivityComponent {

    fun inject(mainActivity: MainActivity)

    @Component.Factory
    interface Factory {
        fun create(mainActivityModule: MainActivityModule): MainActivityComponent
    }

}