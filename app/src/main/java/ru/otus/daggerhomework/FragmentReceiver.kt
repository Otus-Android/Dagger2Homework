package ru.otus.daggerhomework

import android.app.Application
import android.os.Bundle
import android.view.*
import androidx.annotation.ColorInt
import androidx.fragment.app.Fragment
import androidx.lifecycle.*
import kotlinx.coroutines.launch
import javax.inject.Inject

class FragmentReceiver : Fragment() {

    @Inject
    lateinit var application: Application

    @Inject
    lateinit var viewModelReceiver: ViewModelReceiver

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

        DaggerFragmentReceiverComponent
            .builder()
            .applicationComponent((requireActivity().application as App).getAppComponent())
            .mainActivityComponent((requireActivity() as MainActivity).getComponent())
            .build()
            .inject(this)

        frame = view.findViewById(R.id.frame)

        lifecycleScope.launch {
            viewModelReceiver.observeColors().collect { color ->
                color.takeIf { it != -1 }?.let(::populateColor)
            }
        }
    }

    fun populateColor(@ColorInt color: Int) {
        frame.setBackgroundColor(color)
    }
}