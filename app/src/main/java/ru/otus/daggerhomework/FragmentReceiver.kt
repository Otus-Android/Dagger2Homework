package ru.otus.daggerhomework

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.ColorInt
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import io.reactivex.rxjava3.subjects.PublishSubject
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class FragmentReceiver : Fragment() {

    private lateinit var frame: View

    private lateinit var viewModelReceiver: ViewModelReceiver

    @Inject
    lateinit var subject: PublishSubject<Int>

    @ApplicationContext
    @Inject
    lateinit var appContext: Context

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val activity = requireActivity() as MainActivityComponentInterface
        DaggerFragmentReceiverComponent.factory().create(
            mainActivityComponent = activity.getComponent()
        ).inject(this)
        viewModelReceiver = ViewModelReceiver(appContext, subject)
        subscribeOnViewModel()
        return inflater.inflate(R.layout.fragment_b, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        frame = view.findViewById(R.id.frame)
    }

    private fun subscribeOnViewModel() {
        viewModelReceiver.colorFlow.onEach { populateColor(it) }.launchIn(lifecycleScope)
    }

    private fun populateColor(@ColorInt color: Int) {
        frame.setBackgroundColor(color)
    }
}