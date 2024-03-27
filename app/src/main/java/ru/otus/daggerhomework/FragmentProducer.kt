package ru.otus.daggerhomework

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import ru.otus.daggerhomework.di.FragmentProducerComponent

class FragmentProducer : Fragment(R.layout.fragment_a) {

    private lateinit var viewModel: ViewModelProducer

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        FragmentProducerComponent.build((requireActivity() as MainActivity).mainActivityComponent).let { component ->
            val contextFromComponent = component.provideContext()
            val colorGenerator = component.provideColorGenerator()
            val observer = component.provideObserver()
            val factory = ViewModelProducer.Factory(colorGenerator, observer)
            viewModel = ViewModelProvider(this, factory)[ViewModelProducer::class.java]

            view.findViewById<Button>(R.id.button).setOnClickListener {
                viewModel.generateColor(contextFromComponent)
            }
        }
    }
}