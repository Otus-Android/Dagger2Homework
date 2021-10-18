package ru.otus.daggerhomework

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import ru.otus.daggerhomework.di.component.DaggerFragmentProducerComponent
import javax.inject.Inject

class FragmentProducer : Fragment() {

    @Inject
    lateinit var viewModel: ViewModelProducer

    override fun onAttach(activity: Activity) {
        super.onAttach(activity)
        val activityComponent = (activity as MainActivity).mainActivityComponent
        DaggerFragmentProducerComponent.builder().mainActivityComponent(activityComponent).build()
            .injectFragmentProducer(this)

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
            viewModel.generateColor()
        }
    }
}