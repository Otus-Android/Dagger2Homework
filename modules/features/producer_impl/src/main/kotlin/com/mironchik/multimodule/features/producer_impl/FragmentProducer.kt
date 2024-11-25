package com.mironchik.multimodule.features.producer_impl

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.mironchik.multimodule.base.colors.ColorsControllerProvider
import com.mironchik.multimodule.base.colors.ColorsGeneratorImpl
import com.mironchik.multimodule.core.api.AggregatingHolder
import javax.inject.Inject

class FragmentProducer : Fragment() {
    @Inject
    lateinit var viewModel: ViewModelProducer

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_producer, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        DaggerFragmentProducerComponent.factory()
            .create(
                (requireActivity().application as AggregatingHolder).aggregatingProvider,
                (requireActivity() as ColorsControllerProvider),
                ColorsGeneratorImpl(),
            )
            .inject(this)
        view.findViewById<Button>(R.id.button).setOnClickListener {
            viewModel.generateColor()
        }
    }
}