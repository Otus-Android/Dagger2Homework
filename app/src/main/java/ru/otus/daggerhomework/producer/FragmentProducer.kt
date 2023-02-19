package ru.otus.daggerhomework.producer

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import ru.otus.daggerhomework.MainActivity
import ru.otus.daggerhomework.R
import ru.otus.daggerhomework.components.Empty
import ru.otus.daggerhomework.components.FragmentProducerComponent
import ru.otus.daggerhomework.components.Success
import javax.inject.Inject

class FragmentProducer : Fragment() {


    @Inject
    lateinit var producerComponent: FragmentProducerComponent
    //lateinit var viewModelFactory: ViewModelFactory

    private lateinit var viewModel: ViewModelProducer

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (activity as MainActivity).mainActivityComponent.provideProducerComponent().create()
            .inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.fragment_a, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel =
            producerComponent.provideViewModelFactory().create(ViewModelProducer::class.java)
        view.findViewById<Button>(R.id.button).setOnClickListener {
            //отправить результат через livedata в другой фрагмент
            if ((activity as MainActivity).mainActivityComponent.provideActivityContext() !is FragmentActivity) throw RuntimeException(
                "Здесь нужен контекст активити"
            )
            Toast.makeText(context, "Color sent", Toast.LENGTH_LONG).show()
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
                    else -> {}
                }
            }
        }
    }
}