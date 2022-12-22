package ru.otus.daggerhomework

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.ColorInt
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import ru.otus.daggerhomework.di.components.DaggerFragmentReceiverComponent
import javax.inject.Inject
import javax.inject.Provider


class FragmentReceiver : Fragment() {

    @Inject
    lateinit var dataKeeper: Provider<IDataKeeper>

    private lateinit var frame: View
    private lateinit var viewModelReceiver: ViewModelReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activityComponent = (requireActivity() as MainActivity).activityComponent
        val fragmentReceiverComponent = DaggerFragmentReceiverComponent
            .builder()
            .activityComponent(activityComponent)
            .build()
        fragmentReceiverComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModelReceiver = ViewModelReceiver(
            requireContext().applicationContext,
            dataKeeper.get()
        )
        lifecycleScope.launch {
            viewModelReceiver.observeColors()
        }

        return inflater.inflate(R.layout.fragment_b, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        frame = view.findViewById(R.id.frame)

        lifecycleScope.launch {
            viewModelReceiver.colorData.collect { colorCode ->
                populateColor(colorCode)
            }
        }
    }

    private fun populateColor(@ColorInt color: Int) {
        frame.setBackgroundColor(color)
    }
}