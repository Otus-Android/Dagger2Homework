package ru.otus.daggerhomework

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.annotation.ColorInt
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.collect
import ru.otus.daggerhomework.di.DaggerFragmentComponent
import ru.otus.daggerhomework.di.FragmentComponent
import ru.otus.daggerhomework.di.ViewModelFactory
import javax.inject.Inject

class FragmentReceiver : Fragment() {

    private lateinit var frame: View

    lateinit var fragmentComponent: FragmentComponent

    @Inject
    lateinit var factoryViewModel: ViewModelFactory
    val viewModel by viewModels<ViewModelReceiver> {
        factoryViewModel
    }
    override fun onAttach(context: Context) {
        super.onAttach(context)
        fragmentComponent = DaggerFragmentComponent.factory().create(
            (requireActivity() as MainActivity).activityComponent
        )
        fragmentComponent.injectFragmentReceiver(this)
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

        lifecycleScope.launchWhenStarted {
            viewModel.stateChanel.collect{color ->
                viewModel.observeColors()
                populateColor(color)
            }
        }
    }

    private fun populateColor(@ColorInt color: Int) {
        frame.setBackgroundColor(color)
    }
}