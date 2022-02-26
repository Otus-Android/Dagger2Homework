package ru.otus.daggerhomework.base

import android.view.View
import androidx.fragment.app.Fragment

inline fun <T : View> Fragment.callView(viewId: Int, block: T.() -> Unit) {
    view?.findViewById<T>(viewId)?.apply(block)
}