package ru.otus.daggerhomework

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.ColorInt
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.launch
import ru.otus.daggerhomework.di.DaggerFragmentReceiverComponent
import javax.inject.Inject

class FragmentReceiver : Fragment() {

    private lateinit var frame: View

    @Inject
    lateinit var viewModelReceiver: ViewModelReceiver

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_b, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        frame = view.findViewById(R.id.frame)
        DaggerFragmentReceiverComponent
            .factory()
            .create((requireActivity() as MainActivity).component)
            .inject(this)
        viewModelReceiver.observeColors()
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModelReceiver.color.collect { color: Int? -> color?.let { populateColor(it) }}
            }
        }
    }

    private fun populateColor(@ColorInt color: Int) {
        frame.setBackgroundColor(color)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewModelReceiver.clear()
    }
}