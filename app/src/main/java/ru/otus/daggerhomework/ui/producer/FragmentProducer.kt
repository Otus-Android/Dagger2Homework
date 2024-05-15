package ru.otus.daggerhomework.ui.producer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import ru.otus.daggerhomework.R
import ru.otus.daggerhomework.di.components.DaggerFragmentComponent
import ru.otus.daggerhomework.ui.MainActivity
import javax.inject.Inject

class FragmentProducer : Fragment() {

    @Inject
    lateinit var viewModelProducer: ViewModelProducer

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
        return inflater.inflate(R.layout.fragment_a, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.button).setOnClickListener {
            lifecycleScope.launch {
                viewModelProducer.generateColor()
            }
        }
    }
}