package ru.otus.daggerhomework.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import ru.otus.daggerhomework.*
import ru.otus.daggerhomework.di.ActivityContext
import ru.otus.daggerhomework.viewmodels.ViewModelProducer
import javax.inject.Inject

class FragmentProducer @Inject constructor(
    private val colorGenerator: ColorGenerator,
    private val observer: EventBus,
    @ActivityContext private val activityContext: Context
) : Fragment() {

    private val viewModel by viewModels<ViewModelProducer> {
        ViewModelProducer.Factory(
            colorGenerator,
            observer,
            activityContext
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_a, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.button).setOnClickListener {
            //отправить результат через livedata в другой фрагмент
            viewModel.generateColor()
        }
    }
}