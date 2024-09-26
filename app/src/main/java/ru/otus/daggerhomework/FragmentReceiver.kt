package ru.otus.daggerhomework

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.annotation.ColorInt
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class FragmentReceiver : Fragment(R.layout.fragment_b) {

    @Inject
    lateinit var viewModelProvider: ViewModelReceiver.Factory

    private val viewModel: ViewModelReceiver by viewModels { viewModelProvider }

    private lateinit var frame: View

    private lateinit var fragmentReceiverComponent: FragmentReceiverComponent

    override fun onAttach(context: Context) {
        super.onAttach(context)
        fragmentReceiverComponent = (requireActivity() as MainActivity).mainActivityComponent
            .getFragmentReceiverComponent().create(requireContext())
        fragmentReceiverComponent.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        frame = view.findViewById(R.id.frame)

        lifecycleScope.launch {
            viewModel.colorObserver.collect {
                Log.d("RECEIVER", "receive $it")
                populateColor(it)
            }
        }
    }

    private fun populateColor(@ColorInt color: Int) {
        frame.setBackgroundColor(color)
    }
}