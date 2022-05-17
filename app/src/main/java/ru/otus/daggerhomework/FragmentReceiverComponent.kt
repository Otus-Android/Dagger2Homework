package ru.otus.daggerhomework

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Component
import dagger.Module
import dagger.multibindings.IntoMap

@FragmentScoped
@Component(
    dependencies = [MainActivityComponent::class, ApplicationComponent::class],
    modules = [ReceiverModule::class]
)
interface FragmentReceiverComponent {

    @Component.Factory
    interface Factory {
        fun create(
            applicationComponent: ApplicationComponent,
            mainActivityComponent: MainActivityComponent
        ): FragmentReceiverComponent
    }

    fun inject(fragment: FragmentReceiver)
}

@Module
interface ReceiverModule {

    @Binds
    @IntoMap
    @ViewModelKey(ViewModelReceiver::class)
    abstract fun viewModelReceiver(viewModel: ViewModelReceiver): ViewModel
}

