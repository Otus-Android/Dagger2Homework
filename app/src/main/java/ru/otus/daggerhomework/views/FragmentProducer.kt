package ru.otus.daggerhomework.views

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.flow.MutableStateFlow
import ru.otus.daggerhomework.App
import ru.otus.daggerhomework.R
import ru.otus.daggerhomework.di.components.DaggerActivityComponent
import ru.otus.daggerhomework.di.components.DaggerFragmentProducerComponent
import ru.otus.daggerhomework.di.components.FragmentProducerComponent
import ru.otus.daggerhomework.viewModels.ViewModelProducer
import javax.inject.Inject


class FragmentProducer : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
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
        DaggerFragmentProducerComponent
            .factory()
            .create((requireActivity() as MainActivity).activityComponent)
            .inject(this)
        viewModel = viewModelFactory.create(ViewModelProducer::class.java)
        view.findViewById<Button>(R.id.button).setOnClickListener {
            viewModel.generateColor()
            (requireActivity() as MainActivity).showFragment(FragmentReceiver())

        }
    }
}
