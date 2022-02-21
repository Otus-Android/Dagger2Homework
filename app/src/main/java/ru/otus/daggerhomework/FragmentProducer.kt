package ru.otus.daggerhomework

import android.content.Context
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
       ViewModelProvider(this,viewModelFactory)[ViewModelProducer::class.java]
   }

    lateinit var fragmentProducerComponent: FragmentProducerComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        fragmentProducerComponent = (activity as MainActivity).mainActivityComponent.fragmentProducerComponent().create()
        fragmentProducerComponent.inject(this)
        super.onCreate(savedInstanceState)
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
           viewModelProducer.generateColor()
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.container_fragment, FragmentReceiver())
                .addToBackStack(null)
                .commit()//отправить результат через livedata в другой фрагмент
        }
    }
}