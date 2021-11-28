package ru.otus.daggerhomework

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import javax.inject.Inject

class FragmentProducer : Fragment() {
    @Inject
    lateinit var viewModelFactory: ViewModelFactoryProducer
    private val viewModelProducer: ViewModelProducer by viewModels { viewModelFactory }

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
            view.findViewById<Button>(R.id.button).setOnClickListener {
                viewModelProducer.generateColor()
            }
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        DaggerFragmentProducerComponent
            .factory()
            .create((requireActivity() as MainActivity).activityComponent)
            .inject(this)
    }
}