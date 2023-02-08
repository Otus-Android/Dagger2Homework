package ru.otus.daggerhomework.di


import android.content.Context
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.flow.MutableStateFlow
import ru.otus.daggerhomework.MainActivity


@MainActivityScope
@Component(
    modules = [StateObserver::class],
    dependencies = [ApplicationComponent::class]
)
interface MainActivityComponent {

    fun provideObserver(): MutableStateFlow<Int>

    @ActivityContext
    fun provideActivityContext():Context

    fun inject(activity: MainActivity)

    @Component.Factory
    interface ActivityComponentFactory {
        fun create(
            @BindsInstance @ActivityContext context: Context,
            applicationComponent: ApplicationComponent
        ): MainActivityComponent
    }
}


@Module
object StateObserver {

    @MainActivityScope
    @Provides
    fun provideObservable(): MutableStateFlow<Int> {
        return MutableStateFlow(0)
    }
}

