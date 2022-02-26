package ru.otus.daggerhomework.base

import androidx.lifecycle.LifecycleCoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect

fun <T> Flow<T>.launchWhenStarted(
    lifecycleCoroutineScope: LifecycleCoroutineScope,
    block: (T) -> Unit
) {
    lifecycleCoroutineScope.launchWhenCreated {
        this@launchWhenStarted.collect {
            block.invoke(it)
        }
    }
}