package ru.otus.daggerhomework

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Named

class FragmentProducer : Fragment() {

    private var component: FragmentProducerComponent? = null

    @Inject
    @Named("ProducerFactory")
    lateinit var viewModel: ViewModelProducer

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_a, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        component = (requireActivity() as MainActivity).getActivityComponent()
            .addFragmentProducerComponent()
            .create()

//        viewModel = ViewModelProvider(this, viewModelFactory).get(ViewModelProducer::class.java)

        view.findViewById<Button>(R.id.button).setOnClickListener {
            //отправить результат через livedata в другой фрагмент
            viewModel.sendEvent()
        }
    }
}