package ru.otus.daggerhomework.di

import android.content.Context
import dagger.Component
import dagger.Module
import dagger.Provides
import ru.otus.daggerhomework.FlowObserver
import ru.otus.daggerhomework.ViewModelReceiverFactory

/**
 * @author Юрий Польщиков on 08.08.2021
 */
@Component(
    modules = [FragmentReceiverModule::class],
    dependencies = [
        MainActivityComponent::class
    ]
)
@FragmentScope
interface FragmentReceiverComponent {

    fun getViewModelReceiverFactory(): ViewModelReceiverFactory

    @Component.Factory
    interface Factory {

        fun create(
            mainActivityComponent: MainActivityComponent
        ): FragmentReceiverComponent
    }

    companion object {
        fun create(@ActivityContext context: Context): FragmentReceiverComponent {
            return DaggerFragmentReceiverComponent.factory()
                .create(
                    (context as MainActivityComponentProvider).getMainActivityComponent()
                )
        }
    }
}

@Module
interface FragmentReceiverModule {

    companion object {

        @Provides
        fun provideViewModelReceiverFactory(
            flowObserver: FlowObserver<Int>,
            @AppContext context: Context
        ) = ViewModelReceiverFactory(flowObserver, context)
    }
}
