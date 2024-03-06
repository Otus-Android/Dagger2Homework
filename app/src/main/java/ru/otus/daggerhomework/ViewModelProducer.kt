package ru.otus.daggerhomework

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import java.lang.ref.WeakReference
import javax.inject.Inject

class ViewModelProducer @Inject constructor(
    val colorGenerator: ColorGenerator,
    context: Context
) : ViewModel() {

    val contextThis : WeakReference<Context> = WeakReference(context)
    fun changeColor() {
        if (contextThis.get() !is MainActivity) throw RuntimeException("Здесь нужен контекст активити")
        colorGenerator.generateColor()
        Toast.makeText(contextThis.get(), "Color sent", Toast.LENGTH_SHORT).show()
    }
}

class ViewModelProducerFactory @Inject constructor(
    private val colorGenerator: ColorGenerator,
    private val context: Context
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ViewModelProducer(colorGenerator, context) as T
    }
}

@Component(
    modules = [ViewModelProducerModule::class, ColorGeneratorModule::class],
)
interface ViewModelProducerComponent {
    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance context: Context,
        ): ViewModelProducerComponent
    }

    fun inject(fragmentProducer: FragmentProducer)
}

@Module
interface ViewModelProducerModule {
    @Binds
    fun bindFactory(viewModelProducerFactory: ViewModelProducerFactory): ViewModelProvider.Factory
}