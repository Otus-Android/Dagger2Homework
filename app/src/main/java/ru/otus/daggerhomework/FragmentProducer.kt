package ru.otus.daggerhomework

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import ru.otus.daggerhomework.di.DaggerFragmentProducerComponent
import ru.otus.daggerhomework.di.ViewModelFactory
import ru.otus.daggerhomework.di.injectViewModel
import javax.inject.Inject

class FragmentProducer : Fragment() {

    @Inject
    lateinit var factory: ViewModelFactory
    private lateinit var producerViewModel: ViewModelProducer

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        DaggerFragmentProducerComponent
            .builder()
            .mainActivityComponent((requireActivity() as MainActivity).activityComponent)
            .build()
            .inject(this)
        producerViewModel = injectViewModel(factory)
        return inflater.inflate(R.layout.fragment_a, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.button).setOnClickListener {
            //отправить результат через livedata в другой фрагмент
            producerViewModel.generateColor()
        }
    }
}