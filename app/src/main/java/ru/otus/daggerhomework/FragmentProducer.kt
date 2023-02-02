package ru.otus.daggerhomework

import android.app.Application
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import ru.otus.daggerhomework.di.DaggerFragmentProducerComponent
import ru.otus.daggerhomework.di.DaggerMainActivityComponent
import ru.otus.daggerhomework.di.FragmentProducerComponent
import java.util.*
import javax.inject.Inject

private const val TAG = "FragmentProducer"

class FragmentProducer : Fragment() {

    @Inject lateinit var app: Application
    @Inject lateinit var mainActivity: MainActivity

    lateinit var observer: Observer
    lateinit var colorGenerator: ColorGenerator

    private val viewModelProducer by viewModels<ViewModelProducer> {
        ViewModelProducerFactory(observer, colorGenerator, mainActivity)
    }

    lateinit var fragmentProducerComponent: FragmentProducerComponent

    override fun onCreate(savedInstanceState: Bundle?) {

        val mainActivityComponent =
            DaggerMainActivityComponent.factory().create(
                (requireActivity().application as App).applicationComponent,
                mainActivity
            )

        fragmentProducerComponent =
            DaggerFragmentProducerComponent
                .factory()
                .create(mainActivityComponent)

        fragmentProducerComponent.inject(this)

        Log.d(TAG, app.toString())

        super.onCreate(savedInstanceState)
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
            viewModelProducer.generateColor()
        }
    }
}