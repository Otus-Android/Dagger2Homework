package ru.otus.daggerhomework

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import javax.inject.Inject

class FragmentProducer : Fragment() {

    @Inject
    lateinit var viewModelProducer: ViewModelProducer

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_a, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        DaggerFragmentProducerComponent
            .builder()
            .applicationComponent((requireActivity().application as App).getAppComponent())
            .mainActivityComponent((requireActivity() as MainActivity).getComponent())
            .build()
            .inject(this)

        view.findViewById<Button>(R.id.button).setOnClickListener {
            viewModelProducer.generateColor()
        }
    }
}