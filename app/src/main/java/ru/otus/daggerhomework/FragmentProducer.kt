package ru.otus.daggerhomework

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import javax.inject.Inject

class FragmentProducer : Fragment() {
    
    @Inject
    lateinit var viewModelFactory: ViewModelProducerFactory
    private val viewModel: ViewModelProducer by viewModels { viewModelFactory }
    
    override fun onAttach(context: Context) {
        super.onAttach(context)
        val dependenciesProvider = activity as? DependenciesProvider<FragmentProducerDependencies>
            ?: throw ClassCastException(
                "Activity must implement `DependenciesProvider` of `FragmentProducerDependencies`"
            )
        DaggerFragmentProducerComponent.builder()
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
            viewModel.onButtonClick()
        }
    }
}