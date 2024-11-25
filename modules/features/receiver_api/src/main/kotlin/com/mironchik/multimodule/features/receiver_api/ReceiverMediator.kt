package com.mironchik.multimodule.features.receiver_api

import androidx.annotation.IdRes
import androidx.fragment.app.FragmentManager

interface ReceiverMediator {
    fun openReceiver(
        fragmentManager: FragmentManager,
        @IdRes container: Int,
    )
}