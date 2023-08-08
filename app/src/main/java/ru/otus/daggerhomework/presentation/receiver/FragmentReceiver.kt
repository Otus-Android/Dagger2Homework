package ru.otus.daggerhomework.presentation.receiver

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.ColorInt
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.launch
import ru.otus.daggerhomework.R
import ru.otus.daggerhomework.di.receiver.FragmentReceiverComponent
import ru.otus.daggerhomework.presentation.provider
import javax.inject.Inject

/**
 * `Fragment`-а получения цветов
 */
class FragmentReceiver : Fragment() {

    private var _frame: View? = null
    private var _textView: TextView? = null

    private val frame: View get() = _frame!!
    private val textView: TextView get() = _textView!!

    @Inject
    lateinit var receiver: ViewModelReceiver

    override fun onAttach(context: Context) {
        super.onAttach(context)
        FragmentReceiverComponent.create(provider().mainActivityComponent).inject(this)
        lifecycle.addObserver(receiver)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_b, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _frame = view.findViewById(R.id.frame)
        _textView = view.findViewById(R.id.color_text_view)

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                receiver.uiState.collect { state -> renderUi(state) }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _frame = null
        _textView = null
    }

    private fun renderUi(state: ColorUiState) {
        when (state) {
            ColorUiState.Idle -> textView.text = getString(R.string.empty)
            is ColorUiState.Success -> populateColor(state.color)
            is ColorUiState.Error -> textView.text = state.message
        }
    }

    private fun populateColor(@ColorInt color: Int) {
        textView.text = color.toString()
        frame.setBackgroundColor(color)
    }
}