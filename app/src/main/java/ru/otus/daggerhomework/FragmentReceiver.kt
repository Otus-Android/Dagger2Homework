package ru.otus.daggerhomework

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.annotation.ColorInt
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.stupkalex.rostok.di.ViewModelFactory
import javax.inject.Inject

class FragmentReceiver : Fragment() {

    private lateinit var frame: View

    @Inject
    lateinit var viewModuleFactory: ViewModelFactory

    private lateinit var viewModel: ViewModelReceiver

    override fun onAttach(context: Context) {
        (activity as MainActivity).component.fragmentReceiverComponentFactory().create().inject(this)
        super.onAttach(context)
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
        viewModel = ViewModelProvider(this, viewModuleFactory)[ViewModelReceiver::class.java]
        frame = view.findViewById(R.id.frame)
        viewModel.observeColors(this::populateColor)
    }

    fun populateColor(@ColorInt color: Int) {
        frame.setBackgroundColor(color)
    }
}