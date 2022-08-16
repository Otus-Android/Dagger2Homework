package ru.otus.daggerhomework

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dagger.Lazy
import javax.inject.Inject

class FragmentProducer : Fragment() {

    @Inject
    @AppName
    lateinit var applicationContext: Context

    @Inject
    internal lateinit var viewModelFactory: Lazy<ViewModelProducer.Factory>
    private val viewModel: ViewModelProducer by viewModels { viewModelFactory.get() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DaggerFragmentProducerComponent.builder()
            .applicationComponent((requireActivity().application as App).getAppComponent())
            .mainActivityComponent((requireActivity() as MainActivity).activityComponent())
            .build().inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_a, container, true)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.button).setOnClickListener {
            //отправить результат через livedata в другой фрагмент
            viewModel.generateColor()
        }
    }
}