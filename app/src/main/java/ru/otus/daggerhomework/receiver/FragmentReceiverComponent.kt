package ru.otus.daggerhomework.receiver

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Component
import dagger.Module
import dagger.Provides
import ru.otus.daggerhomework.Event
import ru.otus.daggerhomework.FragmentScope
import ru.otus.daggerhomework.MainActivityComponent
import ru.otus.daggerhomework.app.ApplicationComponent
import javax.inject.Named

@FragmentScope
@Component(
    dependencies = [
        ApplicationComponent::class,
        MainActivityComponent::class
    ],
    modules = [FragmentReceiverModule::class]
)
interface FragmentReceiverComponent {

    fun inject(fragmentReceiver: FragmentReceiver)
}

@Module
class FragmentReceiverModule {

    @Provides
    fun provideReceiverViewModelFactory(
        @Named("app") context: Context,
        event: Event<Int>,
    ): ViewModelProvider.Factory {
        return object : ViewModelProvider.Factory {

            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                require(modelClass == ReceiverViewModel::class.java)
                return ReceiverViewModel(context, event) as T
            }
        }
    }
}
