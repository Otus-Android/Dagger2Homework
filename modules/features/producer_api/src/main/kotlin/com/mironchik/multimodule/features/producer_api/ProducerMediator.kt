package com.mironchik.multimodule.features.producer_api

import androidx.annotation.IdRes
import androidx.fragment.app.FragmentManager


interface ProducerMediator {
    fun openProducer(
        fragmentManager: FragmentManager,
        @IdRes container: Int,
    )
}