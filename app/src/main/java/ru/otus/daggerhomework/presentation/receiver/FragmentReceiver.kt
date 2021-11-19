package ru.otus.daggerhomework.presentation.receiver

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.ColorInt
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import ru.otus.daggerhomework.R
import ru.otus.daggerhomework.di.DaggerFragmentReceiverComponent
import ru.otus.daggerhomework.presentation.main.MainActivity

class FragmentReceiver : Fragment() {

    private lateinit var frame: View
    private lateinit var viewModel: ViewModelReceiver

    companion object {
        const val TAG = "FragmentReceiver"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val component = DaggerFragmentReceiverComponent.builder()
            .mainActivityComponent((requireActivity() as MainActivity).mainComponent)
            .build()

        component.inject(this)

        viewModel = ViewModelProvider(this).get(ViewModelReceiver::class.java)
            .also { component.inject(it) }
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

        viewModel.observeColors(::populateColor)
    }

    private fun populateColor(@ColorInt color: Int) {
        frame.setBackgroundColor(color)
    }
}