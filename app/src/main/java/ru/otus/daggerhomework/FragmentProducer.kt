package ru.otus.daggerhomework

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject

class FragmentProducer : Fragment() {
    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel: ViewModelProducer by lazy {
        ViewModelProvider(this, viewModelFactory)[ViewModelProducer::class.java]
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
       FragmentProducerComponent.getFragmentProducerComponent(
          (requireActivity() as MainActivity).mainActivityComponent).inject(this)
        view.findViewById<Button>(R.id.button).setOnClickListener {
            viewModel.generateColor()
        }
    }
}