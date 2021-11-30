package ru.otus.daggerhomework.presentation.producer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import ru.otus.daggerhomework.R
import ru.otus.daggerhomework.di.components.DaggerFragmentProducerComponent
import ru.otus.daggerhomework.di.dependencies.DependenciesProvider
import ru.otus.daggerhomework.di.dependencies.FragmentProducerDependencies
import ru.otus.daggerhomework.presentation.receiver.FragmentReceiver
import javax.inject.Inject

class FragmentProducer : Fragment() {

    companion object {
        const val TAG = "FragmentProducer"
    }

    @Inject
    lateinit var viewModelFactory: ViewModelProducerFactory
    private val viewModel: ViewModelProducer by viewModels { viewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val dependenciesProvider = activity as? DependenciesProvider<FragmentProducerDependencies>
            ?: throw ClassCastException(
                "Activity must implement `DependenciesProvider` of `FragmentProducerDependencies`"
            )

        DaggerFragmentProducerComponent
            .builder()
            .fragmentProducerDependencies(dependenciesProvider.getDependencies())
            .build()
            .inject(this)

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
            viewModel.generateColor()
            requireActivity().supportFragmentManager
                .beginTransaction()
                .add(R.id.container_layout, FragmentReceiver(), FragmentReceiver.TAG)
                .addToBackStack(null)
                .commit()
        }
    }
}