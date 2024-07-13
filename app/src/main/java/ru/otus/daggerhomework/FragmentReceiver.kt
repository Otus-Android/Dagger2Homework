package ru.otus.daggerhomework

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.annotation.ColorInt
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import javax.inject.Inject
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class FragmentReceiver: Fragment(R.layout.fragment_b) {

    private lateinit var frame: View

    @Inject
    lateinit var receiverViewModel: ViewModelReceiver

    override fun onAttach(context: Context) {
        super.onAttach(context)

        DaggerReceiverComponent
            .factory()
            .create((requireActivity() as MainActivity).activityComponent)
            .inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        receiverViewModel.observeColors()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        frame = view.findViewById(R.id.frame)


        receiverViewModel.colorReceiver.listenColorEvent()
            .onEach { populateColor(it) }
            .launchIn(lifecycleScope)
    }

    private fun populateColor(@ColorInt color: Int) {
        frame.setBackgroundColor(color)
    }
}