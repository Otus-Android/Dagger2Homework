package ru.otus.daggerhomework.receiver

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.ColorInt
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import dagger.Lazy
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import ru.otus.daggerhomework.MainActivity
import ru.otus.daggerhomework.R
import javax.inject.Inject

class FragmentReceiver : Fragment() {

    private lateinit var frame: View

    @Inject
    lateinit var viewModelReceiver: Lazy<ViewModelReceiver>

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity() as MainActivity).activityComponent
            .fragmentReceiverComponent().create().inject(this)

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



        lifecycleScope.launchWhenStarted {
            viewModelReceiver.get().color
                .onEach {
                    populateColor(it)
                }
                .collect()
        }
    }


    private fun populateColor(@ColorInt color: Int) {
        frame.setBackgroundColor(color)
    }
}