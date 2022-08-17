package ru.otus.daggerhomework.screens.producer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import ru.otus.daggerhomework.screens.main.MainActivity
import ru.otus.daggerhomework.R
import ru.otus.daggerhomework.di.DaggerFragmentProducerComponent
import ru.otus.daggerhomework.di.ViewModelFactory
import ru.otus.daggerhomework.injectViewModel
import javax.inject.Inject

class FragmentProducer : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    lateinit var viewModel: ViewModelProducer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activityComponent = (requireActivity() as MainActivity).getActivityComponent()
        val fragmentProducerComponent =
            DaggerFragmentProducerComponent.factory().create(activityComponent)
        fragmentProducerComponent.inject(this)

        viewModel = injectViewModel(viewModelFactory)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_a, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.button).setOnClickListener {
            viewModel.generateColor()
        }
        view.findViewById<Button>(R.id.reset).setOnClickListener {
            viewModel.reset()
        }
    }
}