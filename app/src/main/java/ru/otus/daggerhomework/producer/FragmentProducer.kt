package ru.otus.daggerhomework.producer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import ru.otus.daggerhomework.MainActivity
import ru.otus.daggerhomework.R
import ru.otus.daggerhomework.components.Empty
import ru.otus.daggerhomework.components.Success
import javax.inject.Inject

class FragmentProducer : Fragment() {


    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel: ViewModelProducer by viewModels { viewModelFactory }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.fragment_a, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity() as MainActivity).mainActivityComponent
            .addProducerComponent()
            .injectToFragmentProducer(this)
        view.findViewById<Button>(R.id.button).setOnClickListener {
            //отправить результат через livedata в другой фрагмент
            viewModel.generateColor()
        }
        val textView = view.findViewById<TextView>(R.id.tvText)
        viewModel.apply {
            state.observe(viewLifecycleOwner) {
                when (it) {
                    is Success -> {
                        val text = "${textView.text}${it.message}\n"
                        textView.text = text
                    }
                    Empty -> {}
                }
            }
        }
    }
}