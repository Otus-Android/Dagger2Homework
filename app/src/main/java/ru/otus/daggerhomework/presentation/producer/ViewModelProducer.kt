package ru.otus.daggerhomework.presentation.producer

import android.content.Context
import android.widget.Toast
import androidx.annotation.ColorInt
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.channels.SendChannel
import kotlinx.coroutines.launch
import ru.otus.daggerhomework.R
import ru.otus.daggerhomework.di.utils.qualifiers.ActivityContext
import ru.otus.daggerhomework.presentation.color.ColorGenerator
import javax.inject.Inject

class ViewModelProducer @Inject constructor(
    private val channel: SendChannel<@JvmSuppressWildcards Int>,
    private val colorGenerator: ColorGenerator,
    @ActivityContext private val context: Context
) : DefaultLifecycleObserver {
    init {
        if (context !is FragmentActivity) throw RuntimeException(context.resources.getString(R.string.activity_context_requirement))
    }

    private val scope = CoroutineScope(SupervisorJob() + Dispatchers.Main.immediate)

    fun generateColor() {
        val newColor = colorGenerator.generateColor()
        showToast(newColor)
        scope.launch {
            channel.send(element = newColor)
        }
    }

    private fun showToast(@ColorInt color: Int) =
        Toast.makeText(context, context.getString(R.string.color_sent, color), Toast.LENGTH_SHORT)
            .show()

    override fun onDestroy(owner: LifecycleOwner) = scope.cancel()
}