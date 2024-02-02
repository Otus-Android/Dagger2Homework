package ru.otus.daggerhomework

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.annotation.ColorInt
import androidx.fragment.app.Fragment
import javax.inject.Inject

class FragmentReceiver : Fragment() {

    private lateinit var frame: View

    private val subcomponent by lazy {
        FragmentReceiverComponent.getFragmentReceiverComponent((requireContext() as App).component)
    }

    @Inject
    lateinit var мiewModelReceiver: ViewModelReceiver

    override fun onAttach(context: Context) {
        super.onAttach(context)
        subcomponent.inject(this)
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
        мiewModelReceiver.colorLiveData.observe(viewLifecycleOwner){
            populateColor(it)
        }
    }

    fun populateColor(@ColorInt color: Int) {
        frame.setBackgroundColor(color)
    }
}