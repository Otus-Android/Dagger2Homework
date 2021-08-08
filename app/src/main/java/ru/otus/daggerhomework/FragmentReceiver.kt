package ru.otus.daggerhomework

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.ColorInt
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import ru.otus.daggerhomework.di.FragmentReceiverComponent

class FragmentReceiver : Fragment() {

    private lateinit var frame: View
    private lateinit var viewModel: ViewModelReceiver

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

        val fragmentReceiverComponent = FragmentReceiverComponent.create(requireActivity())

        viewModel = ViewModelProvider(viewModelStore, fragmentReceiverComponent.getViewModelReceiverFactory())
            .get(ViewModelReceiver::class.java)

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.color.collect {
                populateColor(it)
            }
        }
    }

    private fun populateColor(@ColorInt color: Int) {
        frame.setBackgroundColor(color)
    }
}
