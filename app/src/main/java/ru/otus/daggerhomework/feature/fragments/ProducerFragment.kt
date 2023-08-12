package ru.otus.daggerhomework.feature.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import ru.otus.daggerhomework.App
import ru.otus.daggerhomework.R
import ru.otus.daggerhomework.activity.MainActivity
import ru.otus.daggerhomework.feature.di.ProducerFragmentComponent
import ru.otus.daggerhomework.feature.viewmodels.ProducerViewModel
import javax.inject.Inject

class ProducerFragment : Fragment() {

    @Inject
    lateinit var viewModel: ProducerViewModel

    override fun onAttach(context: Context) {
        super.onAttach(context)
        ProducerFragmentComponent.create(
            requireActivity().application as App,
            requireActivity() as MainActivity
        ).inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_producer, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.button).setOnClickListener {
            viewModel.onButtonClick()
        }
    }
}