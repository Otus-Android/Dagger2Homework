package ru.otus.daggerhomework.receiver

import android.os.Bundle
import android.view.View
import androidx.annotation.ColorInt
import androidx.fragment.app.Fragment
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import ru.otus.daggerhomework.Event
import ru.otus.daggerhomework.R
import ru.otus.daggerhomework.main.impl.di.MainActivityComponent
import ru.otus.daggerhomework.receiver.di.FragmentReceiverComponent

class FragmentReceiver : Fragment(R.layout.fragment_b) {

    private lateinit var frame: View
    private val mViewModel by lazy(LazyThreadSafetyMode.NONE) {
        FragmentReceiverComponent.getInstance().viewModelProviderFactory
            .create(ViewModelReceiver::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        frame = view.findViewById(R.id.frame)
        mViewModel.events.flowWithLifecycle(viewLifecycleOwner.lifecycle)
            .onEach(::render)
            .launchIn(viewLifecycleOwner.lifecycleScope)
    }

    override fun onDestroy() {
        super.onDestroy()
        FragmentReceiverComponent.release()
    }

    private fun render(event: Event) {
        when (event) {
            is Event.ShowColor -> populateColor(event.color)
        }
    }

    private fun populateColor(@ColorInt color: Int) {
        frame.setBackgroundColor(color)
        mViewModel.observeColors()
    }
}