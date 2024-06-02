package ru.otus.daggerhomework

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.channels.SendChannel
import kotlinx.coroutines.launch
import ru.otus.daggerhomework.di.activity.ActivityContextQualifier
import javax.inject.Inject

class ViewModelProducer2 @Inject constructor(
    private val observable: SendChannel<@JvmSuppressWildcards LocalEvent>,
    private val colorGenerator: ColorGenerator,
    @ActivityContextQualifier
    private val activityContext: Context
) : ViewModelMarkerInterface {

    private val viewModelScope = CoroutineScope(Dispatchers.Main.immediate + SupervisorJob())

    fun generateColor() {
        if (activityContext !is FragmentActivity) throw RuntimeException("Здесь нужен контекст активити")

        viewModelScope.launch {
            try {
                observable.send(LocalEvent.ColorData(colorGenerator.generateColor()))
                Toast.makeText(activityContext, "Color sent", Toast.LENGTH_SHORT).show()
            } catch (e: CancellationException) {
                throw e
            } catch (e: Exception) {
                observable.send(LocalEvent.Error(e))
            }
        }
    }

    override fun disposeResources() {
        viewModelScope.cancel()
    }
}