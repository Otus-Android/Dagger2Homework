package ru.otus.daggerhomework.presentation.producer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import ru.otus.daggerhomework.R
import ru.otus.daggerhomework.di.DaggerFragmentProducerComponent
import ru.otus.daggerhomework.presentation.main.MainActivity
import ru.otus.daggerhomework.presentation.receiver.FragmentReceiver

class FragmentProducer : Fragment() {

    companion object {
        const val TAG = "FragmentProducer"
    }

    lateinit var viewModel: ViewModelProducer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val component = DaggerFragmentProducerComponent.builder()
            .mainActivityComponent((requireActivity() as MainActivity).mainComponent)
            .build()

        component.inject(this)

        viewModel = ViewModelProvider(this).get(ViewModelProducer::class.java)
            .also { component.inject(it) }
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
            requireActivity().supportFragmentManager
                .beginTransaction()
                .add(R.id.container_layout, FragmentReceiver(), FragmentReceiver.TAG)
                .addToBackStack(null)
                .commit()
        }
    }
}