package ru.otus.daggerhomework

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.annotation.BinderThread
import androidx.annotation.ColorInt
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import dagger.Binds
import javax.inject.Inject

interface ColorReceiver {
    fun populateColor(@ColorInt color: Int)
}

class FragmentReceiver : Fragment(), ColorReceiver {

    @Inject
    lateinit var appContext : Context

    private lateinit var viewModel : ViewModelReceiver
    private lateinit var frame : View

    override fun onAttach(context: Context) {
        super.onAttach(context)
        ((context as Activity).application as App).appComponent.createFragmentReceiverComponent().inject(this)
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
        viewModel.init(this as ColorReceiver, this)
    }

    override fun populateColor(@ColorInt color: Int) {
        frame.setBackgroundColor(color)
    }

}