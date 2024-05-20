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
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModelProducer: ViewModelProducer

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_a, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        initListeners()
    }

    private fun init() {
        FragmentProducerComponent.create((requireActivity() as MainActivity).getMainComponent())
            .inject(this)
        viewModelProducer = viewModelFactory.create(ViewModelProducer::class.java)
    }

    private fun initListeners() {
        view?.findViewById<Button>(R.id.button_generate_color)?.setOnClickListener {
            viewModelProducer.generateColor(requireActivity())
        }
        view?.findViewById<Button>(R.id.button_open_receiver)?.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, FragmentReceiver(), "")
                .addToBackStack(null)
                .commit()
        }
    }
}