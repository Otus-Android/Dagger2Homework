package ru.otus.daggerhomework

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.ColorInt
import androidx.fragment.app.Fragment
import ru.otus.daggerhomework.di.DaggerFragmentReceiverComponent
import javax.inject.Inject

class FragmentReceiver : Fragment() {

    @Inject
    lateinit var viewModelReceiver: ViewModelReceiver

    private lateinit var frame: View

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

    override fun onAttach(context: Context) {
        super.onAttach(context)
        DaggerFragmentReceiverComponent
            .builder()
            .activityComponent((requireActivity() as MainActivity).appComponent)
            .applicationComponent((requireActivity().applicationContext as App).getAppComponent())
            .build()
            .inject(this)
    }
}