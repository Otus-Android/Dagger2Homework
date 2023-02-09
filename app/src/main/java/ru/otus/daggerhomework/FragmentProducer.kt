package ru.otus.daggerhomework

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import kotlinx.coroutines.flow.MutableStateFlow
import ru.otus.daggerhomework.di.DaggerFragmentComponent
import ru.otus.daggerhomework.di.FragmentComponent
import ru.otus.daggerhomework.di.ViewModelFactory
import javax.inject.Inject
import kotlin.random.Random

class FragmentProducer : Fragment() {

    lateinit var fragmentComponent: FragmentComponent

    @Inject
    lateinit var state: MutableStateFlow<Int>

    @Inject
    lateinit var factoryViewModel: ViewModelFactory
    val viewModel by viewModels<ViewModelProducer> {
        factoryViewModel
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        fragmentComponent = DaggerFragmentComponent.factory().create(
            (requireActivity() as MainActivity).activityComponent
        )
        fragmentComponent.injectFragmentProducer(this)
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