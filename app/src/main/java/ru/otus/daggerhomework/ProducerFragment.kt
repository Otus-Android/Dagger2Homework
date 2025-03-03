package ru.otus.daggerhomework

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import ru.otus.daggerhomework.di.DaggerProducerFragmentComponent
import ru.otus.daggerhomework.di.ProducerFragmentComponent
import javax.inject.Inject

class ProducerFragment : Fragment(R.layout.fragment_producer) {

    @Inject
    lateinit var viewModelFactory: ProducerViewModel.Factory

    private lateinit var viewModel: ProducerViewModel

    private lateinit var fragmentProducerComponent: ProducerFragmentComponent

    override fun onAttach(context: Context) {
        super.onAttach(context)

        fragmentProducerComponent = DaggerProducerFragmentComponent
            .factory()
            .create((requireActivity() as MainActivity).activityComponent)

        fragmentProducerComponent.inject(this)

        viewModel = ViewModelProvider(this, viewModelFactory)[ProducerViewModel::class.java]
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.button).setOnClickListener {
            //отправить результат через flow в другой фрагмент
            viewModel.generateColor()
        }
    }
}
