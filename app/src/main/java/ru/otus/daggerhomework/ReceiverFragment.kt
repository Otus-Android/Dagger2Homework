package ru.otus.daggerhomework

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.ColorInt
import androidx.fragment.app.Fragment
import javax.inject.Inject

class ReceiverFragment : Fragment() {

    @Inject
    lateinit var viewModel: ReceiverViewModel

    private lateinit var frame: View

    override fun onAttach(context: Context) {
        (activity as MainActivity).receiverFragmentComponent.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_receiver, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        frame = view.findViewById(R.id.frame)
    }

    fun populateColor(@ColorInt color: Int) {
        viewModel.observeColors()
        frame.setBackgroundColor(color)
    }
}