package ru.otus.daggerhomework

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch
import ru.otus.daggerhomework.di.activity.ActivityContextQualifier
import java.lang.ref.WeakReference
import javax.inject.Inject

class ViewModelProducer @Inject constructor(
    private val observer: Channel<LocalEvent>,
    private val colorGenerator: ColorGenerator,
    @ActivityContextQualifier
    activityContext: Context
) : ViewModel() {

    private val weakContextRef = WeakReference(activityContext)
    private val context: Context
        get() = weakContextRef.get()!!

    fun generateColor() {
        if (context !is FragmentActivity) throw RuntimeException("Здесь нужен контекст активити")
        Toast.makeText(context, "Color sent", Toast.LENGTH_LONG).show()

        viewModelScope.launch {
            try {
                observer.send(LocalEvent.ColorData(colorGenerator.generateColor()))
            } catch (e: CancellationException) {
                throw e
            } catch (e: Exception) {
                observer.send(LocalEvent.Error(e))
            }
        }
    }
}