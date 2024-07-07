package ru.otus.daggerhomework

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import ru.otus.daggerhomework.di.DaggerFragmentProducerComponent
import ru.otus.daggerhomework.di.FragmentProducerComponent
import ru.otus.daggerhomework.di.MainActivityComponentHolder
//import ru.otus.daggerhomework.di.DaggerFragmentProducerComponent
import javax.inject.Inject

class FragmentProducer : Fragment() {

    @Inject
    lateinit var viewModelProducer: ViewModelProducer

    lateinit var fragmentProducerComponent: FragmentProducerComponent

    override fun onAttach(context: Context) {
        super.onAttach(context)

        fragmentProducerComponent = DaggerFragmentProducerComponent.factory()
            .create((requireActivity() as MainActivityComponentHolder).getActivityComponent())

        fragmentProducerComponent.inject(this)

//        DaggerFragmentProducerComponent.factory().create(
//            (requireActivity() as MainActivity).mainActivityComponent
//        ).inject(this)
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
        }
    }
}