package ru.otus.daggerhomework

import dagger.BindsInstance
import dagger.Component
import javax.security.auth.Subject

@Component
interface MainActivityComponent {

    fun provideSubject(): Subject

    @Component.Factory
    interface Factory {

        fun create(@BindsInstance context: MainActivity, @BindsInstance subject: Subject): MainActivityComponent
    }
}