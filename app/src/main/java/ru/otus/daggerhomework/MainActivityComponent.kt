package ru.otus.daggerhomework

import dagger.Component
import dagger.Subcomponent

//@Subcomponent()
interface MainActivityComponent {
    fun inject(mainActivity: MainActivity)
}