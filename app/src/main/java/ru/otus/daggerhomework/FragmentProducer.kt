package ru.otus.daggerhomework

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import ru.otus.daggerhomework.di.DaggerApplicationComponent
import ru.otus.daggerhomework.di.DaggerFragmentProducerComponent
import ru.otus.daggerhomework.di.FragmentProducerComponent
import javax.inject.Inject

class FragmentProducer : Fragment() {

    private val viewModel by viewModels<ViewModelProducer>()

    //private val viewModel by activityViewModels<ViewModelProducer>

    @Inject
    lateinit var applicationContext: Context

    lateinit var fragmentProducerComponent: FragmentProducerComponent

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_a, container, true)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        fragmentProducerComponent =
            DaggerFragmentProducerComponent
                .factory()
                .create((activity?.application as App).appComponent)

        fragmentProducerComponent.inject(this)

        Log.d("F", applicationContext.toString())

        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.button).setOnClickListener {
            //отправить результат через livedata в другой фрагмент
        }
    }
}