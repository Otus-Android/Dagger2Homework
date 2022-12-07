package ru.otus.daggerhomework

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.ColorInt
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import ru.otus.daggerhomework.di.ActivityContext
import ru.otus.daggerhomework.di.ApplicationContext
import ru.otus.daggerhomework.di.components.DaggerFragmentReceiverComponent
import ru.otus.daggerhomework.di.components.FragmentReceiverComponent
import javax.inject.Inject
import javax.inject.Provider


class FragmentReceiver : Fragment() {

    @Inject
    lateinit var dataKeeper: Provider<IDataKeeper>

    @Inject
    @ApplicationContext
    lateinit var applicationContext: Context

    private lateinit var frame: View
    private lateinit var fragmentReceiverComponent: FragmentReceiverComponent
    private lateinit var viewModelReceiver: ViewModelReceiver

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val activityComponent = (requireActivity() as MainActivity).activityComponent
        fragmentReceiverComponent = DaggerFragmentReceiverComponent
            .builder()
            .activityComponent(activityComponent)
            .build()
        fragmentReceiverComponent.inject(this)

        viewModelReceiver = ViewModelReceiver(
            applicationContext,
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