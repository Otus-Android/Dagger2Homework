package ru.otus.daggerhomework

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.ColorInt
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch

class FragmentReceiver : Fragment() {

    private lateinit var frame: View
    private lateinit var fragmentReceiverComponent: FragmentReceiverComponent

    private val selfViewModel: ViewModelReceiver by viewModels {
        AssistedSavedStateViewModelFactory(this) {
            fragmentReceiverComponent.viewModelReceiver().create(it)
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        fragmentReceiverComponent = (activity as MainActivity).mainActivityComponent
            .fragmentReceiverComponent()
            .create()

    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_b, container, true)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        frame = view.findViewById(R.id.frame)

        viewLifecycleOwner.lifecycleScope.launch {
            selfViewModel.colorState.collect { color ->
                if (color != null) {
                    populateColor(color)
                }
            }
        }
    }

    fun populateColor(@ColorInt color: Int) {
        frame.setBackgroundColor(color)
    }
}