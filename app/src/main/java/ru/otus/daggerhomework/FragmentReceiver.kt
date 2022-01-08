package ru.otus.daggerhomework

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.ColorInt
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.launch
import ru.otus.daggerhomework.di.DaggerFragmentReceiverComponent
import ru.otus.daggerhomework.di.ViewModelFactory
import ru.otus.daggerhomework.di.injectViewModel
import javax.inject.Inject

class FragmentReceiver : Fragment() {

    private lateinit var frame: View

    @Inject
    lateinit var factory:  ViewModelFactory
    private lateinit var receiverViewModel: ViewModelReceiver

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        DaggerFragmentReceiverComponent
            .builder()
            .mainActivityComponent((requireActivity() as MainActivity).activityComponent)
            .build()
            .inject(this)
        receiverViewModel = injectViewModel(factory)
        return inflater.inflate(R.layout.fragment_b, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        frame = view.findViewById(R.id.frame)
//        with(viewLifecycleOwner) {
//            lifecycleScope.launch {
//                repeatOnLifecycle(Lifecycle.State.CREATED) {
//                    receiverViewModel.observeColors { populateColor(it) }
//                }
//            }
//        }
        receiverViewModel.observeColors { populateColor(it) }
    }

    private fun populateColor(@ColorInt color: Int) {
        frame.setBackgroundColor(color)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        receiverViewModel.stopObservingColors()
    }
}