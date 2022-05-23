package ru.otus.daggerhomework.producer

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import ru.otus.daggerhomework.R
import ru.otus.daggerhomework.producer.di.FragmentProducerComponent

class FragmentProducer : Fragment(R.layout.fragment_a) {

    private val mViewModel by lazy(LazyThreadSafetyMode.NONE) {
        FragmentProducerComponent.getInstance().viewModelProviderFactory
            .create(ViewModelProducer::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.button).setOnClickListener {
            mViewModel.generateColor()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        FragmentProducerComponent.release()
    }

}