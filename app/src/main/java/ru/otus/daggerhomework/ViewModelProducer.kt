package ru.otus.daggerhomework

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import java.lang.ref.WeakReference
import javax.inject.Inject
import kotlinx.coroutines.launch

class ViewModelProducer(
    private val colorGenerator: ColorGenerator,
    context: Context,
    private val stateObserver: ProducerStateObserver
) : ViewModel() {

  private val context: WeakReference<Context> = WeakReference(context)

  fun generateColor() {
    if (context.get() !is FragmentActivity) throw RuntimeException("Здесь нужен контекст активити")
    Toast.makeText(context.get(), "Color sent", Toast.LENGTH_LONG).show()
    viewModelScope.launch { stateObserver.setState(colorGenerator.generateColor()) }
  }
}

class ViewModelProviderFactory
@Inject
constructor(
    private val colorGenerator: ColorGenerator,
    @ActivityContext private val context: Context,
    private val stateObserver: ProducerStateObserver
) : ViewModelProvider.Factory {

  override fun <T : ViewModel> create(modelClass: Class<T>): T {
    return when (modelClass) {
      ViewModelProducer::class.java -> {
        ViewModelProducer(colorGenerator, context, stateObserver)
      }
      else -> throw IllegalArgumentException("Unknown ViewModel class")
    }
        as T
  }
}
