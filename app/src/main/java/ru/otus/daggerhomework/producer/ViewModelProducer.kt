package ru.otus.daggerhomework.producer

import android.content.Context
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.LifecycleCoroutineScope
import kotlinx.coroutines.launch
import ru.otus.daggerhomework.di.ActivityContext
import ru.otus.daggerhomework.utils.ColorGenerator
import ru.otus.daggerhomework.utils.Notification
import javax.inject.Inject

class ViewModelProducer @Inject constructor(
    @ActivityContext
    private val context: Context,
    private val colorGenerator: ColorGenerator,
    private val notification: Notification,
    private val lifecycleCoroutineScope: LifecycleCoroutineScope
) {
    fun generateColor() {
        lifecycleCoroutineScope.launch {
            if (context !is FragmentActivity) throw RuntimeException("Здесь нужен контекст активити")
            val color = colorGenerator.generateColor()
            notification.sendEvent(color)
        }
    }
}