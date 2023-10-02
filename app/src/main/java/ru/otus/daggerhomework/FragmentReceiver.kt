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
import javax.inject.Inject
import kotlinx.coroutines.launch

class FragmentReceiver : Fragment() {

    @Inject lateinit var viewModel: ViewModelReceiver

    private var frame: View? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_b, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        DaggerFragmentReceiverComponent.factory()
            .create((requireActivity() as MainActivity).mainActivityComponent)
            .inject(this)

        frame = view.findViewById(R.id.frame)

        lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.colorFlow.collect {color ->
                    color?.let { populateColor(color) }
                }
            }
        }

        viewModel.observeColors()
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.onClear()
    }

    private fun populateColor(@ColorInt color: Int) {
        frame?.setBackgroundColor(color)
    }
}