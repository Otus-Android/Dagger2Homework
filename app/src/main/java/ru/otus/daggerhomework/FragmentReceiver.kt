package ru.otus.daggerhomework

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.annotation.ColorInt
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import ru.otus.daggerhomework.di.DaggerFragmentReceiverComponent
import ru.otus.daggerhomework.di.MainActivityComponent
import ru.otus.daggerhomework.di.ReceiverViewModel
import javax.inject.Inject

class FragmentReceiver : Fragment(R.layout.fragment_b) {
    @Inject
    @field:ReceiverViewModel
    lateinit var viewModelReceiverFactory: ViewModelProvider.Factory
    private lateinit var viewModelReceiver: ViewModelReceiver

    private lateinit var frame: View

    override fun onAttach(context: Context) {
        super.onAttach(context)

        DaggerFragmentReceiverComponent
            .factory()
            .create(MainActivityComponent.mainActivityComponentInstance!!, this.requireContext().applicationContext)
            .inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        frame = view.findViewById(R.id.frame)

        viewModelReceiver = ViewModelProvider(this, viewModelReceiverFactory).get(ViewModelReceiver::class.java)

        lifecycleScope.launch {
            viewModelReceiver.observeColors()

            viewModelReceiver.stateFlow.collect {
                populateColor(it)
            }
        }
    }

    private fun populateColor(@ColorInt color: Int) {
        frame.setBackgroundColor(color)
    }
}