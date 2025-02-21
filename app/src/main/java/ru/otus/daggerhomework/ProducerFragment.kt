package ru.otus.daggerhomework

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import ru.otus.daggerhomework.di.DaggerProducerFragmentComponent
import ru.otus.daggerhomework.di.ProducerFragmentComponent
import javax.inject.Inject


class ProducerFragment : Fragment() {

    private lateinit var viewModel: ProducerViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val component = DaggerProducerFragmentComponent
            .factory()
            .build(requireActivity().component, requireActivity())
        viewModel = component.viewModel()

        return inflater.inflate(R.layout.fragment_producer, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.button).setOnClickListener {
            viewModel.generateColor()
        }
    }
}