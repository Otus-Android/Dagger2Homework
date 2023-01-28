package ru.otus.daggerhomework

import android.app.Application
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.ColorInt
import androidx.fragment.app.Fragment
import ru.otus.daggerhomework.di.DaggerFragmentReceiverComponent
import ru.otus.daggerhomework.di.FragmentReceiverComponent
import javax.inject.Inject

class FragmentReceiver : Fragment() {

    @Inject lateinit var app: Application

    private lateinit var frame: View

    private lateinit var fragmentReceiverComponent: FragmentReceiverComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        fragmentReceiverComponent =
            DaggerFragmentReceiverComponent
                .factory()
                .create((requireActivity().application as App).applicationComponent)
        fragmentReceiverComponent.inject(this)

        super.onCreate(savedInstanceState)
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
    }

    fun populateColor(@ColorInt color: Int) {
        frame.setBackgroundColor(color)
    }
}