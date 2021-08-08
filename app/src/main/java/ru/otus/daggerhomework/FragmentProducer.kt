package ru.otus.daggerhomework

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import ru.otus.daggerhomework.di.FragmentProducerComponent

class FragmentProducer : Fragment() {

    private lateinit var viewModel: ViewModelProducer

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_a, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val fragmentProducerComponent = FragmentProducerComponent.create(requireActivity())
        viewModel = ViewModelProvider(viewModelStore, fragmentProducerComponent.getViewModelProducerFactory())
            .get(ViewModelProducer::class.java)

        view.findViewById<Button>(R.id.button).setOnClickListener {
            //отправить результат через livedata в другой фрагмент
            viewLifecycleOwner.lifecycleScope.launch {
                viewModel.generateColor()
            }
        }
    }
}
