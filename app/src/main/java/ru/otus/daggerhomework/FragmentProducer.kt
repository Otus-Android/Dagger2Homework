package ru.otus.daggerhomework

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import ru.otus.daggerhomework.di.FragmentProducerComponent
import javax.inject.Inject

class FragmentProducer : Fragment() {


    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel by viewModels<ViewModelProducer> { viewModelFactory }

    lateinit var fragmentComponent: FragmentProducerComponent

    private var bColored: Button? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_a, container, false)
        fragmentComponent =
            (requireActivity() as MainActivity).activityComponent.fragmentProducerComponent()
                .create()
        fragmentComponent.inject(this)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bColored = view.findViewById(R.id.button)

        bColored?.setOnClickListener {
            viewModel.generateColor()
        }

    }
}