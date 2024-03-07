package ru.otus.daggerhomework

import dagger.BindsInstance
import dagger.Component
import io.reactivex.rxjava3.subjects.PublishSubject

@Component
interface MainActivityComponent {

    fun provideSubject(): PublishSubject<Int>

    fun provideMainActivityContext(): MainActivity

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: MainActivity, @BindsInstance subject: PublishSubject<Int>): MainActivityComponent
    }
}