package ru.otus.daggerhomework.receiver

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.ColorInt
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import ru.otus.daggerhomework.MainActivity
import ru.otus.daggerhomework.R
import javax.inject.Inject

class FragmentReceiver : Fragment() {

    private lateinit var frame: View

    @Inject
    lateinit var viewModelReceiverFactory: ViewModelReceiverFactory
    private lateinit var viewModelReceiver: ViewModelReceiver

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        initDagger()
        viewModelReceiver =
            ViewModelProvider(this, viewModelReceiverFactory).get(ViewModelReceiver::class.java)
        viewModelReceiver.observeColors()
        return inflater.inflate(R.layout.fragment_b, container, false)
    }

    private fun initDagger() {
        DaggerFragmentReceiverComponent.factory()
            .create((activity as MainActivity).mainActivityComponent).inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        frame = view.findViewById(R.id.frame)
        lifecycleScope.launch {
            viewModelReceiver.receiver.collect {
                populateColor(it)
            }
        }
    }

    fun populateColor(@ColorInt color: Int) {
        frame.setBackgroundColor(color)
    }
}