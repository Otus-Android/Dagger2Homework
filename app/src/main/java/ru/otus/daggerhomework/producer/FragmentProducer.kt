package ru.otus.daggerhomework.producer

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import ru.otus.daggerhomework.MainActivity
import ru.otus.daggerhomework.R
import ru.otus.daggerhomework.di.components.DaggerFragmentProducerComponent
import javax.inject.Inject

class FragmentProducer : Fragment() {

    @Inject
    lateinit var viewModel: ProducerViewModel

    override fun onAttach(activity: Activity) {
        super.onAttach(activity)

        val activityComponent = (activity as MainActivity).mainActivityComponent

        // происходит инжектинг ViewModel в поле
        DaggerFragmentProducerComponent.builder().mainActivityComponent(activityComponent).build()
            .injectFragmentProducer(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_producer, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.button).setOnClickListener {
            viewModel.generateColor()
        }
    }
}