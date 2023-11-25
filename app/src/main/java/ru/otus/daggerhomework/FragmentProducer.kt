package ru.otus.daggerhomework

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import ru.otus.daggerhomework.di.DaggerFragmentProducerComponent
import ru.otus.daggerhomework.di.FragmentProducerComponent
import javax.inject.Inject

class FragmentProducer : Fragment() {

    private val fragmentProducerComponent: FragmentProducerComponent by lazy {
        DaggerFragmentProducerComponent
            .factory()
            .create((activity as MainActivity).mainActivityComponent)
    }

    @Inject
    lateinit var viewModelProducer: ViewModelProducer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        fragmentProducerComponent.inject(this)
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
            //отправить результат через livedata в другой фрагмент
            lifecycleScope.launch {
                viewModelProducer.generateColor()
            }
        }
    }
}