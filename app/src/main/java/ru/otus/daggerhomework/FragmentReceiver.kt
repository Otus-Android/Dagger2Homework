package ru.otus.daggerhomework

import android.app.Application
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.annotation.ColorInt
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import io.reactivex.rxjava3.subjects.PublishSubject
import javax.inject.Inject

class FragmentReceiver @Inject constructor(application: Application,publishSubject: PublishSubject<Int>) : Fragment() {

    private lateinit var frame: View

    val viewModel by viewModels<ViewModelReceiver>() {
        ViewModelReceiverFactory(
            application,publishSubject
        )
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
        val colorObserver = Observer<ViewModelReceiver.Result> { it ->
            if (it is ViewModelReceiver.Result.Success) {
                this.populateColor(it.color)
            }

        }

        viewModel.result.observe(viewLifecycleOwner, colorObserver)
        viewModel.observeColors()

    }

    fun populateColor(@ColorInt color: Int) {
        frame.setBackgroundColor(color)
    }
}