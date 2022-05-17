package ru.otus.daggerhomework

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import io.reactivex.subjects.PublishSubject

@ActivityScoped
@Component(dependencies = [ApplicationComponent::class])
interface MainActivityComponent {
    @Component.Factory
    interface Factory {
        fun create(
            applicationComponent: ApplicationComponent,
            @BindsInstance @ActivityContext context: Context,
            @BindsInstance observer: PublishSubject<Int>
        ): MainActivityComponent
    }

    fun inject(activity: MainActivity)

    fun provideObserver(): PublishSubject<Int>

    @ActivityContext
    fun provideActivityContext(): Context
}



