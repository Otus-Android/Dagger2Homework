package ru.otus.daggerhomework

import android.os.Bundle
import android.view.View
import ru.otus.daggerhomework.databinding.FragmentABinding
import javax.inject.Inject

class FragmentProducer : BaseFragment<FragmentABinding>() {

    @Inject
    lateinit var viewModel: ViewModelProducer

    override fun getViewBinding() = FragmentABinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        FragmentProducerComponent.getFragmentProducerComponent((requireActivity() as MainActivity).activityComponent).inject(this)

        binding.button.setOnClickListener {
            viewModel.generateColor()
        }
    }
}