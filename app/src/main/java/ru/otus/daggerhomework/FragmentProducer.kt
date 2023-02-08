package ru.otus.daggerhomework

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import ru.otus.daggerhomework.di.DaggerFragmentProducerComponent
import ru.otus.daggerhomework.di.FragmentProducerComponent
import ru.otus.daggerhomework.di.MainActivityComponent
import javax.inject.Inject
import kotlin.random.Random

class FragmentProducer : Fragment() {

    lateinit var fragmentComponent: FragmentProducerComponent

    @Inject
    lateinit var state:MutableStateFlow<Int>

    override fun onAttach(context: Context) {
        super.onAttach(context)
        fragmentComponent = DaggerFragmentProducerComponent.factory().create(
            (requireActivity() as MainActivity).activityComponent
        )
        fragmentComponent.inject(this)
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
            state.value = Random.nextInt(1,10)
        }
    }
}