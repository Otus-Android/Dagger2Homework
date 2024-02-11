package ru.otus.daggerhomework

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import javax.inject.Inject
import kotlinx.coroutines.launch

class ViewModelProducer(
    private val colorGenerator: ColorGenerator,
    private val context: Context,
    private val stateObserver: StateObserver
) : ViewModel() {

  fun generateColor() {
    if (context !is FragmentActivity) throw RuntimeException("Здесь нужен контекст активити")
    Toast.makeText(context, "Color sent", Toast.LENGTH_LONG).show()
    viewModelScope.launch { stateObserver.setState(colorGenerator.generateColor()) }
  }
}

class ViewModelProviderFactory
@Inject
constructor(
    private val colorGenerator: ColorGenerator,
    @ActivityContext private val context: Context,
    private val stateObserver: StateObserver
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
