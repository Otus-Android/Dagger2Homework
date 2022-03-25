package ru.otus.daggerhomework.views

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.ColorInt
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import ru.otus.daggerhomework.R
import ru.otus.daggerhomework.di.components.DaggerFragmentReceiverComponent
import ru.otus.daggerhomework.di.components.FragmentReceiverComponent
import ru.otus.daggerhomework.viewModels.ViewModelProducer
import ru.otus.daggerhomework.viewModels.ViewModelReceiver
import javax.inject.Inject

class FragmentReceiver : Fragment() {

    private lateinit var frame: View
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    lateinit var viewModel: ViewModelReceiver


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_b, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        DaggerFragmentReceiverComponent
            .factory()
            .create((requireActivity() as MainActivity).activityComponent)
            .inject(this)
        viewModel = viewModelFactory.create(ViewModelReceiver::class.java)
        frame = view.findViewById(R.id.frame)
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.stateFlow.collect {
                populateColor(it)
                viewModel.observeColors()
            }
        }
    }

    fun populateColor(@ColorInt color: Int) {
        frame.setBackgroundColor(color)
    }
}
