package ru.otus.daggerhomework

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import io.reactivex.rxjava3.subjects.PublishSubject
import javax.inject.Qualifier

@Component(dependencies = [ApplicationComponent::class])
interface MainActivityComponent {

    fun provideSubject(): PublishSubject<Int>

    @MainActivityContext
    fun provideMainActivityContext(): Context

    @ApplicationContext
    fun provideApplicationContext(): Context

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance @MainActivityContext context: Context, @BindsInstance subject: PublishSubject<Int>, applicationComponent: ApplicationComponent): MainActivityComponent
    }
}

@Qualifier
annotation class MainActivityContext