package ru.otus.daggerhomework.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.*
import dagger.multibindings.IntoMap
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import ru.otus.daggerhomework.*
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Scope
import kotlin.reflect.KClass

@FragmentScope
@Component(modules = [FragmentProducerModule::class, ViewModelModule::class],
    dependencies = [ActivityComponent::class])
interface FragmentProducerComponent{
    @ExperimentalCoroutinesApi
    @FlowPreview
    fun inject(fragment: FragmentProducer)
}

@Module
interface FragmentProducerModule{
    @Binds
    @FragmentScope
    @IntoMap
    @ExperimentalCoroutinesApi
    @FlowPreview
    @ViewModelKey(ViewModelProducer::class)
    fun bindViewModelProducer(viewModel: ViewModelProducer): ViewModel

    @Binds
    fun bindColorGenerator(colorGenerator: ColorGeneratorImpl): ColorGenerator
}

@FragmentScope
@Component(modules = [FragmentReceiverModule::class, ViewModelModule::class],
    dependencies = [ActivityComponent::class])
interface FragmentReceiverComponent{
    fun inject(fragment: FragmentReceiver)
}

@Module
interface FragmentReceiverModule{
    @Binds
    @IntoMap
    @ViewModelKey(ViewModelReceiver::class)
    @FragmentScope
    fun bindViewModelReceiver(viewModel: ViewModelReceiver): ViewModel
}

@Module
interface ViewModelModule{
    @Binds
    @FragmentScope
    fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}

class ViewModelFactory @Inject constructor(
    private val viewModels: MutableMap<Class<out ViewModel>, Provider<ViewModel>>
) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val viewModelProvider = viewModels[modelClass]
            ?: throw IllegalArgumentException("model class $modelClass not found")
        return viewModelProvider.get() as T
    }
}

@MapKey
annotation class ViewModelKey(val value: KClass<out ViewModel>)

@Scope
annotation class FragmentScope
