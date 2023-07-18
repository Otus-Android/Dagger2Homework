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
import javax.inject.Inject

class FragmentReceiver : Fragment() {

    private lateinit var frame: View
    private lateinit var fragmentReceiverComponent: FragmentReceiverComponent
    @Inject
    internal lateinit var viewModelReceiver: ViewModelReceiver

    override fun onAttach(context: Context) {
        super.onAttach(context)

        fragmentReceiverComponent = (activity as MainActivity).mainActivityComponent
            .fragmentReceiverComponent()
            .create()
        fragmentReceiverComponent.inject(this)

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
            viewModelReceiver.colorState.collect { color ->
                if (color != null) {
                    populateColor(color)
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModelReceiver.clear()
    }

    fun populateColor(@ColorInt color: Int) {
        frame.setBackgroundColor(color)
    }
}