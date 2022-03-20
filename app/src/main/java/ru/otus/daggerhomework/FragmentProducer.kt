package ru.otus.daggerhomework

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import io.reactivex.rxjava3.subjects.PublishSubject
import ru.otus.daggerhomework.viewmodels.ViewModelFactory
import ru.otus.daggerhomework.viewmodels.injectViewModel
import javax.inject.Inject

class FragmentProducer @Inject constructor() : Fragment() {

    @Inject
    protected lateinit var colorGenerator: ColorGenerator

    @Inject
    protected lateinit var publishSubject: PublishSubject<Int>

    @Inject
    protected lateinit var mContext: Context

    @Inject
    protected lateinit var viewModelFactory: ViewModelFactory

    protected lateinit var viewModel : ViewModelProducer

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_a, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = injectViewModel(viewModelFactory)

        view.findViewById<Button>(R.id.button).setOnClickListener {
            viewModel.generateColor()
        }
    }
}