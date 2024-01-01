package ru.otus.daggerhomework

import android.content.Context
import androidx.fragment.app.FragmentActivity
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import javax.inject.Inject

class ColorSharedFlowContainer @Inject constructor(
    private val _mutableColorFlow: MutableSharedFlow<State>
) {

    fun getFlowAsProducer(contextKey: Context): MutableSharedFlow<State> {
        if (contextKey !is FragmentActivity) throw RuntimeException("Inappropriate calling!")
        return _mutableColorFlow
    }

    fun getFlowAsReceiver(): SharedFlow<State> = _mutableColorFlow.asSharedFlow()
}