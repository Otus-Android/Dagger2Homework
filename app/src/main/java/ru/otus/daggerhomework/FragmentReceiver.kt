package ru.otus.daggerhomework

import android.os.*
import android.view.*
import androidx.annotation.*
import androidx.fragment.app.*
import androidx.lifecycle.*
import kotlinx.coroutines.*
import javax.inject.*

class FragmentReceiver : Fragment() {

    @Inject
    lateinit var viewModel: ViewModelReceiver

    private var frame: View? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_b, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        DaggerFragmentReceiverComponent.factory()
            .create((requireActivity() as MainActivity).mainActivityComponent).inject(this)

        frame = view.findViewById(R.id.frame)

        lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.colorFlow.collect { color ->
                    color?.let { populateColor(color) }
                }
            }
        }

        viewModel.observeColors()
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.onCleared()
    }

    private fun populateColor(@ColorInt color: Int) {
        frame?.setBackgroundColor(color)
    }
}