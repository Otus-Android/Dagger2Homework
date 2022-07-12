package ru.otus.daggerhomework

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.annotation.ColorInt
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import ru.otus.daggerhomework.di.FragmentReceiverComponent
import javax.inject.Inject

class FragmentReceiver : Fragment() {

    private lateinit var frame: View

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    val viewModel by viewModels<ViewModelReceiver> { viewModelFactory }

    lateinit var fragmentComponent: FragmentReceiverComponent

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_b, container, false)
        fragmentComponent =
            (requireActivity() as MainActivity).activityComponent.fragmentReceiverComponent()
                .create()
        fragmentComponent.inject(this)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        frame = view.findViewById(R.id.frame)
        initObserver()
    }

    private fun initObserver() {
        viewModel.color.observe(viewLifecycleOwner) {
            populateColor(it)
        }
        viewModel.observeColors()
    }

    private fun populateColor(@ColorInt color: Int) {
        frame.setBackgroundColor(color)
    }
}