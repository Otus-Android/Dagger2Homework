package ru.otus.daggerhomework.receiver

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.ColorInt
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.otus.daggerhomework.MainActivity
import ru.otus.daggerhomework.R
import javax.inject.Inject

class FragmentReceiver : Fragment() {

    private lateinit var frame: View

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private val viewModel: ViewModelReceiver by viewModels { viewModelFactory }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.fragment_b, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity() as MainActivity).mainActivityComponent
            .addReceiverComponent()
            .injectToFragmentReceiver(this)
        frame = view.findViewById(R.id.frame)
        viewModel.viewModelScope.launch {
            viewModel.mColorFlow.collect {
                populateColor(it)
            }
        }

    }

    fun populateColor(@ColorInt color: Int) {
        frame.setBackgroundColor(color)
    }
}