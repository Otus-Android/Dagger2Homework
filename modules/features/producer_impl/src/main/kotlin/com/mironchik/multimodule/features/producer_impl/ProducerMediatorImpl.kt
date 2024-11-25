package com.mironchik.multimodule.features.producer_impl

import androidx.fragment.app.FragmentManager
import com.mironchik.multimodule.features.producer_api.ProducerMediator
import javax.inject.Inject

class ProducerMediatorImpl @Inject constructor() : ProducerMediator {
    override fun openProducer(
        fragmentManager: FragmentManager,
        container: Int
    ) {
        fragmentManager.beginTransaction()
            .replace(container, FragmentProducer())
            .commit()
    }
}