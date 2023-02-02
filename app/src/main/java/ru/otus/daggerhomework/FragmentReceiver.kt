package ru.otus.daggerhomework

import android.app.Application
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.ColorInt
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import ru.otus.daggerhomework.di.DaggerFragmentReceiverComponent
import ru.otus.daggerhomework.di.DaggerMainActivityComponent
import ru.otus.daggerhomework.di.FragmentReceiverComponent
import java.util.*
import javax.inject.Inject

private const val TAG = "FragmentReceiver"

class FragmentReceiver : Fragment() {

    @Inject lateinit var app: Application
    @Inject lateinit var mainActivity: MainActivity

    private lateinit var frame: View

    lateinit var observer: Observer

    private val viewModelReceiver by viewModels<ViewModelReceiver> {
        ViewModelReceiverFactory(observer, app)
    }

    private lateinit var fragmentReceiverComponent: FragmentReceiverComponent

    override fun onCreate(savedInstanceState: Bundle?) {

        val mainActivityComponent =
            DaggerMainActivityComponent
                .factory()
                .create((requireActivity().application as App).applicationComponent, mainActivity)

        fragmentReceiverComponent =
            DaggerFragmentReceiverComponent
                .factory()
                .create(mainActivityComponent)

        fragmentReceiverComponent.inject(this)

        Log.d(TAG, app.toString())

        super.onCreate(savedInstanceState)
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
    }

    fun populateColor(@ColorInt color: Int) {
        frame.setBackgroundColor(color)
    }
}