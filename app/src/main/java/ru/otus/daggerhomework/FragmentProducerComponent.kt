package ru.otus.daggerhomework

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Scope

@Module
class FragmentProducerModule {

    @FragmentScope
    @Provides
    fun providesViewModel(
        @ActivityContext context: Context,
        observer: MutableLiveData<Int>
    ): ViewModelProvider.Factory {
        return ViewModelProviderFactory { ViewModelProducer(context, observer, ColorGeneratorImpl()) }
    }
}

@FragmentScope
@Component(
    dependencies = [MainActivityComponent::class],
    modules = [FragmentProducerModule::class]
)
interface FragmentProducerComponent {

    @Component.Factory
    interface Factory {
        fun create(activityComponent: MainActivityComponent): FragmentProducerComponent
    }

    fun inject(fragment: FragmentProducer)
}

@Scope
annotation class FragmentScope

