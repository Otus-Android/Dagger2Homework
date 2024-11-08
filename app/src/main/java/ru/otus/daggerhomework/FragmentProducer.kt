package ru.otus.daggerhomework

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import ru.otus.daggerhomework.di.DaggerFragmentProducerComponent
import ru.otus.daggerhomework.di.FragmentProducerComponent
import javax.inject.Inject

class FragmentProducer : Fragment(R.layout.fragment_a) {

    @Inject
    lateinit var viewModelFactory: ViewModelProducer.Factory

    private lateinit var viewModel: ViewModelProducer

    private lateinit var fragmentProducerComponent: FragmentProducerComponent

    override fun onAttach(context: Context) {
        super.onAttach(context)

        fragmentProducerComponent = DaggerFragmentProducerComponent
            .factory()
            .create((requireActivity() as MainActivity).activityComponent)

        fragmentProducerComponent.inject(this)

        viewModel = ViewModelProvider(this, viewModelFactory)[ViewModelProducer::class.java]
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.button).setOnClickListener {
            viewModel.generateColor()
        }
    }
}