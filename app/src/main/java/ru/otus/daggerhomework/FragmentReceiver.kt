package ru.otus.daggerhomework

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.ColorInt
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Named

class FragmentReceiver : Fragment() {
    private var component: FragmentReceiverComponent? = null

    @Inject
    lateinit var viewModel: ViewModelReceiver

    private lateinit var frame: View

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_b, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        component = (requireActivity() as MainActivity).getActivityComponent()
            .addFragmentReceiverComponent()
            .create()

        frame = view.findViewById(R.id.frame)
        viewModel.color.observe(viewLifecycleOwner) {
            populateColor(it)
        }
    }

    private fun populateColor(@ColorInt color: Int) {
        frame.setBackgroundColor(color)
    }

}