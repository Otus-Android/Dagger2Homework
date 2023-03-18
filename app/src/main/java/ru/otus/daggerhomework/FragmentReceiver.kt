package ru.otus.daggerhomework

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.ColorInt
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.launch
import javax.inject.Inject

class FragmentReceiver : Fragment() {

    @Inject lateinit var channel: Channel<Int>

    @Inject lateinit var viewModel: ViewModelReceiver

    private lateinit var frame: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        FragmentReceiverComponent.init((requireActivity() as MainActivity).getActivityComponent()).inject(this)
        return inflater.inflate(R.layout.fragment_b, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        frame = view.findViewById(R.id.frame)
        lifecycleScope.launch {
            viewModel.observeColors()
                .consumeEach { populateColor(it) }
        }
    }

    private fun populateColor(@ColorInt color: Int) {
        Toast.makeText(context, "Color received", Toast.LENGTH_LONG).show()
        frame.setBackgroundColor(color)
    }
}