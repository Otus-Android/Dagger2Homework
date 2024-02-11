package ru.otus.daggerhomework

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.ColorInt
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.launch
import ru.otus.daggerhomework.di.DaggerFragmentReceiverComponent
import javax.inject.Inject

class FragmentReceiver : Fragment() {

    @Inject
    lateinit var viewModel: ViewModelReceiver

    private lateinit var frame: View

    override fun onAttach(context: Context) {
        super.onAttach(context)
        DaggerFragmentReceiverComponent
            .factory()
            .create((activity as MainActivity).activityComponent)
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

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.colorFlow.filterNotNull().collect {
                    populateColor(it)
                }
            }
        }
    }

    private fun populateColor(@ColorInt color: Int) {
        frame.setBackgroundColor(color)
    }
}