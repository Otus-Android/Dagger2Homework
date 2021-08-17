package ru.otus.daggerhomework

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import ru.otus.daggerhomework.di.DaggerFragmentProducerComponent
import ru.otus.daggerhomework.di.MainActivityComponent
import ru.otus.daggerhomework.di.ProducerViewModel
import javax.inject.Inject

class FragmentProducer : Fragment(R.layout.fragment_a) {
    @Inject
    @field:ProducerViewModel
    lateinit var viewModelProducerFactory: ViewModelProvider.Factory
    private lateinit var viewModelProducer: ViewModelProducer

    override fun onAttach(context: Context) {
        super.onAttach(context)

        DaggerFragmentProducerComponent
            .factory()
            .create(MainActivityComponent.mainActivityComponentInstance!!, this.requireContext())
            .inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModelProducer = ViewModelProvider(this, viewModelProducerFactory).get(ViewModelProducer::class.java)

        view.findViewById<Button>(R.id.button).setOnClickListener {
            lifecycleScope.launch {
                viewModelProducer.generateColor()
            }
        }
    }
}