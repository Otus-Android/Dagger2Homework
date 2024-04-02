package ru.otus.daggerhomework

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.annotation.ColorInt
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import ru.otus.daggerhomework.di.components.FragmentReceiverComponent
import javax.inject.Inject

class FragmentReceiver : Fragment() {

    @Inject
    lateinit var viewModelReceiver: ViewModelReceiver

    private lateinit var fragmentReceiverComponent: FragmentReceiverComponent
    private lateinit var frame: FrameLayout

    override fun onAttach(context: Context) {
        val mainActivityComponent = (requireActivity() as MainActivity).mainActivityComponent
        fragmentReceiverComponent = mainActivityComponent.fragmentReceiverComponentBuilder().applicationContext((requireActivity() as MainActivity).applicationContext).build()
        fragmentReceiverComponent.inject(this)
        super.onAttach(context)
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

        lifecycleScope.launch(Dispatchers.Main) {
            viewModelReceiver.observeColors().collectLatest { color ->
                populateColor(color)
            }
        }
    }

    private fun populateColor(@ColorInt color: Int) {
        frame.setBackgroundColor(color)
    }
}