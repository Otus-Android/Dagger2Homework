package ru.otus.daggerhomework.presentation.receiver

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.ColorInt
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import ru.otus.daggerhomework.R
import ru.otus.daggerhomework.di.components.DaggerFragmentReceiverComponent
import ru.otus.daggerhomework.di.dependencies.DependenciesProvider
import ru.otus.daggerhomework.di.dependencies.FragmentReceiverDependencies
import javax.inject.Inject

class FragmentReceiver : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelReceiverFactory
    private val viewModel: ViewModelReceiver by viewModels { viewModelFactory }

    private lateinit var frame: View

    companion object {
        const val TAG = "FragmentReceiver"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val providerDependencies = activity as? DependenciesProvider<FragmentReceiverDependencies>
            ?: throw ClassCastException(
                "Activity must implement `DependenciesProvider` of `FragmentReceiverDependencies`"
            )

        DaggerFragmentReceiverComponent
            .builder()
            .fragmentReceiverDependencies(providerDependencies.getDependencies())
            .build()
            .inject(this)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_b, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        frame = view.findViewById(R.id.frame)

        viewModel.observeColors(::populateColor)
    }

    private fun populateColor(@ColorInt color: Int) {
        frame.setBackgroundColor(color)
    }
}