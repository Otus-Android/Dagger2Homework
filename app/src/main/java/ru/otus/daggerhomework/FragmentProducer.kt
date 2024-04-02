package ru.otus.daggerhomework

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import ru.otus.daggerhomework.di.components.FragmentProducerComponent
import javax.inject.Inject

class FragmentProducer : Fragment() {

    @Inject
    lateinit var viewModelProducer: ViewModelProducer

    private lateinit var fragmentProducerComponent: FragmentProducerComponent

    override fun onAttach(context: Context) {
        val mainActivityComponent = (requireActivity() as MainActivity).mainActivityComponent
        fragmentProducerComponent = mainActivityComponent.fragmentProducerComponentBuilder().applicationContext((requireActivity() as MainActivity).applicationContext).build()
        fragmentProducerComponent.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_a, container, true)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.button).setOnClickListener {
            viewModelProducer.generateColor()
        }
    }
}