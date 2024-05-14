package ru.otus.daggerhomework.ui.receiver

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.ColorInt
import androidx.fragment.app.Fragment
import ru.otus.daggerhomework.R
import ru.otus.daggerhomework.di.components.DaggerFragmentComponent
import ru.otus.daggerhomework.ui.MainActivity
import javax.inject.Inject

class FragmentReceiver : Fragment() {

    @Inject
    lateinit var viewModelReceiver: ViewModelReceiver

    private lateinit var frame: View

    override fun onCreate(savedInstanceState: Bundle?) {
        val mainActivityComponent = (requireActivity() as MainActivity).mainActivityComponent
        val fragmentComponent = DaggerFragmentComponent.builder()
            .mainActivityComponent(mainActivityComponent)
            .build()

        fragmentComponent.inject(this)

        super.onCreate(savedInstanceState)
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
    }

    fun populateColor(@ColorInt color: Int) {
        frame.setBackgroundColor(color)
    }
}