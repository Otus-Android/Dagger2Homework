package ru.otus.daggerhomework

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import ru.otus.daggerhomework.di.FragmentProducerComponent
import javax.inject.Inject

class FragmentProducer : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModelProducer by lazy {
        ViewModelProvider(this, viewModelFactory)[ViewModelProducer::class.java]
    }

   /* private val fragmentProducerComponent by lazy {
        FragmentProducerComponent.getFragmentProducerComponent(
            (requireActivity().application as App).getApplicationComponent()
        )
    }*/

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_a, container, true)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //fragmentProducerComponent.inject(this)

        view.findViewById<Button>(R.id.button).setOnClickListener {
            //отправить результат через livedata в другой фрагмент
        }
    }
}