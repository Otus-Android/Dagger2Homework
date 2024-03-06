package ru.otus.daggerhomework

import android.app.Application
import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import java.lang.ref.WeakReference
import javax.inject.Inject

class ViewModelReceiver @Inject constructor(
    context: Context,
    private val colorGenerator: ColorGenerator
) : ViewModel() {
    var showToast = true

    val contextThis : WeakReference<Context> = WeakReference(context)
    suspend fun observeColors(): StateFlow<Int> {
        if (contextThis.get() !is Application) throw RuntimeException("Здесь нужен контекст апликейшена")
        if(showToast){
            Toast.makeText(contextThis.get(), "Color received", Toast.LENGTH_SHORT).show()
            showToast = false}
        return colorGenerator.getColor().stateIn(CoroutineScope(Dispatchers.IO))
    }
}

class ViewModelReceiverFactory @Inject constructor(
    private val  context: Context,
    private val colorGenerator: ColorGenerator
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ViewModelReceiver( context, colorGenerator) as T
    }
}

@Component( modules = [ViewModelReceiverModule::class, ColorGeneratorModule::class]
)
interface ViewModelReceiverComponent {

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance context: Context,
        ): ViewModelReceiverComponent
    }

    fun inject(fragmentReceiver: FragmentReceiver)
}

@Module
interface ViewModelReceiverModule {
    @Binds
    fun bindFactory(viewModelReceiverFactory: ViewModelReceiverFactory): ViewModelProvider.Factory
}