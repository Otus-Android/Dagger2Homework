package ru.otus.daggerhomework

import android.os.Bundle
import android.view.View
import androidx.annotation.ColorInt
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class FragmentReceiver : Fragment(R.layout.fragment_b) {

    @Inject
    lateinit var viewModelReceiver: ViewModelReceiver

    private var frame: View? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        frame = view.findViewById(R.id.frame)

        DaggerFragmentReceiverComponent
            .factory()
            .create((requireActivity() as MainActivity).component)
            .inject(this)

        viewModelReceiver.observeColors()
            .onEach(::populateColor)
            .launchIn(viewLifecycleOwner.lifecycleScope)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        frame = null
    }

    private fun populateColor(@ColorInt color: Int) {
        frame?.setBackgroundColor(color)
    }

    companion object {

        fun newInstance() = FragmentReceiver()
    }
}
