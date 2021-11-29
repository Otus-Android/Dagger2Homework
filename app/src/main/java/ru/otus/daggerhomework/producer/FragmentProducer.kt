package ru.otus.daggerhomework.producer

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import ru.otus.daggerhomework.MainActivity
import ru.otus.daggerhomework.R
import ru.otus.daggerhomework.appComponent
import javax.inject.Inject

class FragmentProducer : Fragment(R.layout.fragment_a) {

    @Inject
    lateinit var producerViewModelFactory: ViewModelProvider.Factory

    private val producerViewModel by viewModels<ProducerViewModel> { producerViewModelFactory }

    private val button by lazy { requireView().findViewById<Button>(R.id.button) }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        DaggerFragmentProducerComponent.builder()
            .applicationComponent(requireContext().appComponent)
            .mainActivityComponent((requireActivity() as MainActivity).mainActivityComponent)
            .build()
            .inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        button.setOnClickListener { producerViewModel.generateColor() }
    }
}
