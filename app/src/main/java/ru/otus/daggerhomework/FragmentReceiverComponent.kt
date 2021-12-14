package ru.otus.daggerhomework

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import dagger.Component
import dagger.Module
import dagger.Provides

@Module
class FragmentReceiverModule {

    @FragmentScope
    @Provides
    fun providesViewModel(
        @AppContext context: Context,
        colorObserver: MutableLiveData<Int>
    ): ViewModelProvider.Factory {
        return ViewModelProviderFactory { ViewModelReceiver(context, colorObserver) }
    }
}

@FragmentScope
@Component(
    dependencies = [ApplicationComponent::class, MainActivityComponent::class],
    modules = [FragmentReceiverModule::class]
)
interface FragmentReceiverComponent {

    @Component.Factory
    interface Factory {
        fun create(
            appComponent: ApplicationComponent,
            activityComponent: MainActivityComponent
        ): FragmentReceiverComponent
    }

    fun inject(fragment: FragmentReceiver)
}