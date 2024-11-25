package com.mironchik.multimodule.features.receiver_impl

import androidx.fragment.app.FragmentManager
import com.mironchik.multimodule.features.receiver_api.ReceiverMediator
import ru.otus.daggerhomework.FragmentReceiver
import javax.inject.Inject

class ReceiverMediatorImpl @Inject constructor() : ReceiverMediator {
    override fun openReceiver(fragmentManager: FragmentManager, container: Int) {
        fragmentManager.beginTransaction()
            .replace(container, FragmentReceiver())
            .commit()
    }
}