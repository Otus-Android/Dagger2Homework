package ru.otus.daggerhomework

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import ru.otus.daggerhomework.di.activity.ActivityContext
import javax.inject.Inject

class ViewModelProducer @Inject constructor(
  private val colorGenerator: ColorGenerator,
  @ActivityContext private val context: Context,
  private val source: MutableStateFlow<Int>
) {

  private val coroutineScope = CoroutineScope(Job() + Dispatchers.Main)

  fun generateColor() {
    if (context !is FragmentActivity) throw RuntimeException("Здесь нужен контекст активити")
    Toast.makeText(context, "Color sent", Toast.LENGTH_LONG).show()
    coroutineScope.launch { source.emit(colorGenerator.generateColor()) }
  }

  fun clear() {
    coroutineScope.cancel()
  }
}