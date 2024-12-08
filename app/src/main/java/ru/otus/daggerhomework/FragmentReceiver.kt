package ru.otus.daggerhomework

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import ru.otus.daggerhomework.di.FragmentReceiverComponent
import javax.inject.Inject

class FragmentReceiver : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel: ViewModelReceiver by lazy {
        ViewModelProvider(this, viewModelFactory)[ViewModelReceiver::class.java]
    }
    private lateinit var frame: View

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_b, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        FragmentReceiverComponent.getInstance(
                (context as MainActivity).mainActivityComponent
            )
            .inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        frame = view.findViewById(R.id.frame)
        viewModel.observeColors(::populateColor)
    }

    fun populateColor(colorNumber: ColorNumber) {
        frame.setBackgroundColor(colorNumber.number)
    }
}