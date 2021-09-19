package ru.otus.daggerhomework.producer

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import ru.otus.daggerhomework.MainActivity
import ru.otus.daggerhomework.R
import javax.inject.Inject

class FragmentProducer : Fragment() {

    @Inject
    lateinit var viewModel: ViewModelProducer

    override fun onAttach(activity: Activity) {
        super.onAttach(activity)
        (activity as MainActivity).mainActivityComponent.fragmentProducerComponent().build()
            .injectFragmentProducer(this)
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
    }
}