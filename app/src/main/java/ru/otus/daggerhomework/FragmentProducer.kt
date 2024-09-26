package ru.otus.daggerhomework

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject

class FragmentProducer : Fragment(R.layout.fragment_a) {

    @Inject
    lateinit var viewModelFactory: ViewModelProducer.Factory

    private val viewModel: ViewModelProducer by viewModels { viewModelFactory }

    private lateinit var fragmentProducerComponent: FragmentProducerComponent

    override fun onAttach(context: Context) {
        super.onAttach(context)
        fragmentProducerComponent = (requireActivity() as MainActivity).mainActivityComponent
            .getFragmentProducerComponent().create(requireContext())
        fragmentProducerComponent.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.button).setOnClickListener {
            Log.d("PRODUCER", "produce")
            viewModel.generateColor()
        }
    }
}