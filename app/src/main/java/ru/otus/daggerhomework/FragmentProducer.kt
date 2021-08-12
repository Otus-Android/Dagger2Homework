package ru.otus.daggerhomework

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import ru.otus.daggerhomework.di.ProducerViewModel
import javax.inject.Inject

class FragmentProducer : Fragment() {
    @Inject
    @field:ProducerViewModel lateinit var viewModelProducerFactory: ViewModelProvider.Factory
    private lateinit var viewModelProducer: ViewModelProducer

    override fun onAttach(context: Context) {
        super.onAttach(context)

        (context as App).applicationComponent.fragmentProducerComponent().create(context).inject(this)
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
            //отправить результат через livedata в другой фрагмент
        }

        viewModelProducer = ViewModelProvider(this, viewModelProducerFactory).get(ViewModelProducer::class.java)
    }
}