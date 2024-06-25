package ru.otus.daggerhomework

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.annotation.ColorInt
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import javax.inject.Inject
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class FragmentReceiver : Fragment(R.layout.fragment_b) {

    private lateinit var frame: View

    @Inject
    lateinit var viewModelFactory : ViewModelFactory

    private val receiverViewModel by lazy(LazyThreadSafetyMode.NONE) {
        viewModelFactory.create(ViewModelReceiver::class.java)
    }

    override fun onAttach(context : Context) {
        super.onAttach(context)

        DaggerReceiverComponent
            .factory()
            .create((requireActivity() as MainActivity).activityComponent)
            .inject(this)
    }

    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        receiverViewModel.observeColors()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        frame = view.findViewById(R.id.frame)

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                receiverViewModel.colorReceiver.listenColorEvent().collectLatest {
                    populateColor(it)
                }
            }
        }
    }

    private fun populateColor(@ColorInt color: Int) {
        frame.setBackgroundColor(color)
    }
}