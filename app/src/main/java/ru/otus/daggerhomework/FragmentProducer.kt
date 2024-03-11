package ru.otus.daggerhomework

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider

class FragmentProducer : Fragment(R.layout.fragment_a) {

    private lateinit var viewModel: ViewModelProducer

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        FragmentProducerComponent.get((requireActivity() as MainActivity).mainActivityComponent).let { component ->
            val context = component.provideContext()
            val colorGenerator = component.provideColorGenerator()
            val observer = component.provideObserver()
            val factory = ViewModelProducer.Factory(colorGenerator, context, observer)
            viewModel = ViewModelProvider(this, factory).get(ViewModelProducer::class.java)
        }
        view.findViewById<Button>(R.id.button).setOnClickListener {
            viewModel.generateColor()
        }
    }
}
