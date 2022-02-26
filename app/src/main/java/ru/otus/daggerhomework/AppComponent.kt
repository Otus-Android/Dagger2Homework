package ru.otus.daggerhomework

import dagger.Component

@Component
interface AppComponent {

    fun inject(application: App?)

}

