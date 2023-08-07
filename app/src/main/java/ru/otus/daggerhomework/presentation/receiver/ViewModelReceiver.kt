package ru.otus.daggerhomework.presentation.receiver

import android.app.Application
import android.content.Context
import android.widget.Toast
import androidx.annotation.ColorInt
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.stateIn
import ru.otus.daggerhomework.R
import ru.otus.daggerhomework.di.utils.qualifiers.ApplicationContext
import javax.inject.Inject

/**
 * Имитация `ViewModel` получения цветов
 *
 * @param channel канал получения числовых значений
 * @param context `application` контекст
 */
class ViewModelReceiver @Inject constructor(
    channel: ReceiveChannel<@JvmSuppressWildcards Int>,
    @ApplicationContext private val context: Context
) : DefaultLifecycleObserver {

    init {
        if (context !is Application) throw RuntimeException(context.resources.getString(R.string.application_context_requirement))
    }

    private val scope = CoroutineScope(SupervisorJob() + Dispatchers.Main.immediate)

    /** UI состояние цвета */
    val uiState = channel.receiveAsFlow()
        .onEach { color -> showToast(color) }
        .map { color -> ColorUiState.Success(color) as ColorUiState }
        .catch { e ->
            if (e !is CancellationException) {
                emit(ColorUiState.Error(e.toString()))
            } else {
                throw e
            }
        }.stateIn(
            scope = scope,
            started = SharingStarted.WhileSubscribed(),
            initialValue = ColorUiState.Idle
        )

    private fun showToast(@ColorInt color: Int) =
        Toast.makeText(
            context, context.getString(R.string.color_received, color), Toast.LENGTH_SHORT
        ).show()

    override fun onDestroy(owner: LifecycleOwner) = scope.cancel()
}