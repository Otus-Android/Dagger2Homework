package ru.otus.daggerhomework

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.annotation.ColorInt
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import ru.otus.daggerhomework.di.FragmentProducerComponent
import ru.otus.daggerhomework.di.FragmentReceiverComponent
import javax.inject.Inject

class FragmentReceiver : Fragment() {

    private lateinit var frame: View

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModuleReceiver by lazy {
        ViewModelProvider(this, viewModelFactory)[ViewModelReceiver::class.java]
    }

    /*private val fragmentReceiverComponent by lazy {
        FragmentReceiverComponent.getFragmentReceiverComponent(
            (requireActivity().application as App).getApplicationComponent()
        )
    }*/

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_b, container, true)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //fragmentReceiverComponent.inject(this)

        frame = view.findViewById(R.id.frame)
    }

    fun populateColor(@ColorInt color: Int) {
        frame.setBackgroundColor(color)
    }
}