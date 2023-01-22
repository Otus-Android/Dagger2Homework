package ru.otus.daggerhomework.receiver

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.ColorInt
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import ru.otus.daggerhomework.R
import ru.otus.daggerhomework.activity.MainActivity
import ru.otus.daggerhomework.applicaion.ViewModelFactory
import javax.inject.Inject

class FragmentReceiver : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel: ViewModelReceiver by viewModels { viewModelFactory }

    private lateinit var frame: View

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_b, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (requireActivity() as MainActivity)
            .activityComponent
            .plusReceiverComponent()
            .injectToFragmentReceiver(this)
        frame = view.findViewById(R.id.frame)
        lifecycleScope.launch {
            viewModel.colorsFlow.collect {
                populateColor(it)
            }
        }
    }

    private fun populateColor(@ColorInt color: Int) {
        frame.setBackgroundColor(color)
    }
}