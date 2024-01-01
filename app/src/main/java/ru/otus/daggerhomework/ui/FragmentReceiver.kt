package ru.otus.daggerhomework.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.ColorInt
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import ru.otus.daggerhomework.R
import ru.otus.daggerhomework.di.FragmentReceiverComponent
import ru.otus.daggerhomework.di.qualifiers.ApplicationQualifier
import javax.inject.Inject

class FragmentReceiver : Fragment() {

    private lateinit var frame: View

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    @Inject
    @ApplicationQualifier
    lateinit var contextApp: Context

    private val viewModuleReceiver by lazy {
        ViewModelProvider(this, viewModelFactory)[ViewModelReceiver::class.java]
    }

    private val fragmentReceiverComponent by lazy {
        FragmentReceiverComponent.getFragmentReceiverComponent(
            (requireActivity() as MainActivity).mainActivityComponent
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_b, container, true)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        frame = view.findViewById(R.id.frame)

        viewModuleReceiver.observeColors(contextApp, ::populateColor)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        fragmentReceiverComponent.inject(this)
    }

    private fun populateColor(@ColorInt color: Int) {
        frame.setBackgroundColor(color)
    }
}