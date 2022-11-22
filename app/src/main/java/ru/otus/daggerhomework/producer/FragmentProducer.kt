package ru.otus.daggerhomework.producer

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import ru.otus.daggerhomework.R
import ru.otus.daggerhomework.ViewBindingFragment
import ru.otus.daggerhomework.databinding.FragmentABinding
import ru.otus.daggerhomework.main.MainActivity
import javax.inject.Inject

class FragmentProducer : ViewBindingFragment<FragmentABinding>(R.layout.fragment_a) {

    @Inject
    lateinit var viewModelProducer: ViewModelProducer

    override fun onAttach(context: Context) {
        super.onAttach(context)
        DaggerFragmentProducerComponent.factory().create(
            (activity as MainActivity).activityComponent
        ).inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentABinding.bind(view).apply {
            button.setOnClickListener {
                lifecycleScope.launch {
                    viewModelProducer.generateColor()
                }
            }
        }
    }
}