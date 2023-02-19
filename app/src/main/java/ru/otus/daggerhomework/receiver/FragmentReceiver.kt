package ru.otus.daggerhomework.receiver

import android.app.Application
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.ColorInt
import androidx.fragment.app.Fragment
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.otus.daggerhomework.MainActivity
import ru.otus.daggerhomework.R
import ru.otus.daggerhomework.components.FragmentReceiverComponent
import javax.inject.Inject

class FragmentReceiver : Fragment() {

    private lateinit var frame: View

    @Inject
    lateinit var receiverComponent: FragmentReceiverComponent
    private lateinit var viewModel: ViewModelReceiver

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (activity as MainActivity).mainActivityComponent.provideReceiverComponent().create()
            .inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.fragment_b, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel =
            receiverComponent.provideViewModelFactory().create(ViewModelReceiver::class.java)
        frame = view.findViewById(R.id.frame)
        viewModel.viewModelScope.launch {
            viewModel.mColorFlow.collect {
                if ((activity as MainActivity).mainActivityComponent.provideApplicationContext()
                        .provideContext() !is Application
                ) throw RuntimeException("Здесь нужен контекст апликейшена")
                populateColor(it)
            }
        }
    }

    fun populateColor(@ColorInt color: Int) {
        frame.setBackgroundColor(color)
    }
}