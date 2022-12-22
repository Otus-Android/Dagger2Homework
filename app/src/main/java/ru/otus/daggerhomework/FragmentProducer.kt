package ru.otus.daggerhomework

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import ru.otus.daggerhomework.di.components.DaggerFragmentProducerComponent
import ru.otus.daggerhomework.di.components.FragmentProducerComponent
import javax.inject.Inject
import javax.inject.Provider

class FragmentProducer : Fragment() {

    @Inject
    lateinit var dataKeeper: Provider<IDataKeeper>

    @Inject
    lateinit var colorGenerator: Provider<ColorGenerator>

    lateinit var viewModelProducer: ViewModelProducer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activityComponent = (requireActivity() as MainActivity).activityComponent
        val fragmentProducerComponent = DaggerFragmentProducerComponent
            .builder()
            .activityComponent(activityComponent)
            .build()

        fragmentProducerComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewModelProducer = ViewModelProducer(
            colorGenerator.get(),
            requireContext(),
            dataKeeper.get()
        )

        return inflater.inflate(R.layout.fragment_a, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.button).setOnClickListener {
            lifecycleScope.launch {
                //отправить результат через livedata в другой фрагмент
                viewModelProducer.generateColor()
            }
        }
    }
}