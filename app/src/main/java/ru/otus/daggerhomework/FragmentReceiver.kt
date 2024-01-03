package ru.otus.daggerhomework

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.ColorInt
import androidx.fragment.app.Fragment
import ru.otus.daggerhomework.di.activity.ActivityComponentHolder
import ru.otus.daggerhomework.di.app.appComponent
import ru.otus.daggerhomework.di.fragments.DaggerFragmentReceiverComponent
import javax.inject.Inject

class FragmentReceiver : Fragment() {

    private lateinit var frame: View

    @Inject
    lateinit var viewModel: ViewModelReceiver2

    private var currentColor: Int = 0xFFFFFF

    override fun onAttach(context: Context) {
        super.onAttach(context)
        DaggerFragmentReceiverComponent
            .builder()
            .setActivityComponent(
                ActivityComponentHolder
                    .getActivityComponent(
                        context.appComponent,
                        requireActivity()
                    )
            )
            .build()
            .inject(this)
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

        viewModel.observeColors(::populateColor)
    }

    private fun populateColor(@ColorInt color: Int) {
        currentColor = color
        frame.setBackgroundColor(currentColor)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt(COLOR_KEY, currentColor)
        super.onSaveInstanceState(outState)
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        if (savedInstanceState != null) {
            populateColor(savedInstanceState.getInt(COLOR_KEY, currentColor))
        }
    }

    companion object {
        private const val COLOR_KEY = "color"
    }
}