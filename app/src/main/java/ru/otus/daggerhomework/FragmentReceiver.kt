package ru.otus.daggerhomework

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.ColorInt
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.filterNotNull
import ru.otus.daggerhomework.R.layout
import javax.inject.Inject

class FragmentReceiver : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelReceiver.Factory

    private lateinit var frame: View
    private lateinit var viewModel: ViewModelReceiver

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        DaggerFragmentReceiverComponent
            .factory()
            .create(requireNotNull((activity as MainActivity).mainActivityComponent))
            .inject(this)
        viewModel = ViewModelProvider(this, viewModelFactory).get(ViewModelReceiver::class.java)

        lifecycleScope.launchWhenStarted {
            viewModel.observeColors()
                .filterNotNull()
                .collect { populateColor(it) }
        }
        return inflater.inflate(layout.fragment_b, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        frame = view.findViewById(R.id.frame)
    }

    private fun populateColor(@ColorInt color: Int) {
        frame.setBackgroundColor(color)
    }
}