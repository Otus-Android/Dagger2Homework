package ru.otus.daggerhomework.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import ru.otus.daggerhomework.R
import ru.otus.daggerhomework.di.FragmentProducerComponent
import ru.otus.daggerhomework.di.qualifiers.ActivityQualifier
import javax.inject.Inject

class FragmentProducer : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    @Inject
    @ActivityQualifier
    lateinit var contextActivity: Context

    private val viewModelProducer by lazy {
        ViewModelProvider(this, viewModelFactory)[ViewModelProducer::class.java]
    }

    private val fragmentProducerComponent by lazy {
        FragmentProducerComponent.getFragmentProducerComponent(
            (requireActivity() as MainActivity).mainActivityComponent
        )
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
            viewModelProducer.generateColor(contextActivity)
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        fragmentProducerComponent.inject(this)
    }
}