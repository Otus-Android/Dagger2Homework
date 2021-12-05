package ru.otus.daggerhomework.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.ColorInt
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.collect
import ru.otus.daggerhomework.EventBus
import ru.otus.daggerhomework.di.ApplicationContext
import ru.otus.daggerhomework.R
import ru.otus.daggerhomework.viewmodels.ViewModelReceiver
import javax.inject.Inject

class FragmentReceiver @Inject constructor(
    private val observer: EventBus,
    @ApplicationContext private val appContext: Context,
    ) : Fragment() {

    private lateinit var frame: View

    private val viewModel by viewModels<ViewModelReceiver> {
        ViewModelReceiver.Factory(
            appContext, observer
        )
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

        viewLifecycleOwner.lifecycleScope.launchWhenResumed {
            viewModel.colorFlow.collect {
                populateColor(it)
            }
        }
    }

    private fun populateColor(@ColorInt color: Int) {
        frame.setBackgroundColor(color)
    }
}