package ru.otus.daggerhomework

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.ColorInt
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import ru.otus.daggerhomework.di.component.DaggerFragmentReceiverComponent
import javax.inject.Inject

class FragmentReceiver : Fragment() {

    lateinit var viewModel: ViewModelReceiver

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var frame: View

    override fun onAttach(activity: Activity) {
        super.onAttach(activity)
        val activityComponent = (activity as MainActivity).mainActivityComponent
        DaggerFragmentReceiverComponent.builder().mainActivityComponent(activityComponent).build()
            .injectFragmentReceiver(this)
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
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(ViewModelReceiver::class.java)
        viewModel.event.observe(viewLifecycleOwner) {
            viewModel.observeColors()
            populateColor(it)
        }
    }

    fun populateColor(@ColorInt color: Int) {
        frame.setBackgroundColor(color)
    }
}