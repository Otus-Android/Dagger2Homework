package ru.otus.daggerhomework.receiver

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.ColorInt
import androidx.fragment.app.Fragment
import ru.otus.daggerhomework.R
import ru.otus.daggerhomework.activity.MainActivity
import javax.inject.Inject

class FragmentReceiver : Fragment() {

    private lateinit var frame: View

    @Inject
    lateinit var viewModel: ViewModelReceiver

    override fun onAttach(context: Context) {
        val activityComponent = (requireActivity() as MainActivity).activityComponent
        DaggerFragmentReceiverComponent
            .builder()
            .mainActivityComponent(activityComponent)
            .build()
            .inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_b, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        frame = view.findViewById(R.id.frame)
        viewModel.observeColors { color ->
            populateColor(color)
        }
    }

    private fun populateColor(@ColorInt color: Int) {
        frame.setBackgroundColor(color)
    }
}