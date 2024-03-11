package ru.otus.daggerhomework

import android.os.Bundle
import android.view.View
import androidx.annotation.ColorInt
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import ru.otus.daggerhomework.di.FragmentReceiverComponent

class FragmentReceiver : Fragment(R.layout.fragment_b) {

    private lateinit var frame: View

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        frame = view.findViewById(R.id.frame)

        FragmentReceiverComponent.build((requireActivity() as MainActivity).mainActivityComponent).let { component ->
            val context = component.provideContext()
            val observer = component.provideObserver()
            val factory = ViewModelReceiver.Factory(context, observer) { color ->
                populateColor(color)
            }
            val viewModel = ViewModelProvider(this, factory)[ViewModelReceiver::class.java]
            viewModel.observeColors()
        }

    }

    private fun populateColor(@ColorInt color: Int) {
        frame.setBackgroundColor(color)
    }
}