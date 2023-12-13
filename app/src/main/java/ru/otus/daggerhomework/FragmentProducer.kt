package ru.otus.daggerhomework

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import javax.inject.Inject

class FragmentProducer : Fragment(R.layout.fragment_a) {

    @Inject
    lateinit var viewModelProducer: ViewModelProducer

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        DaggerFragmentProducerComponent
            .factory()
            .create((requireActivity() as MainActivity).component)
            .inject(this)

        view.findViewById<Button>(R.id.button).setOnClickListener {
            viewModelProducer.generateColor()
        }
    }

    companion object {

        fun newInstance() = FragmentProducer()
    }
}
