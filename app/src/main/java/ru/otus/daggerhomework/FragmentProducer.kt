package ru.otus.daggerhomework

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import ru.otus.daggerhomework.di.activity.ActivityComponentHolder
import ru.otus.daggerhomework.di.app.appComponent
import ru.otus.daggerhomework.di.fragments.DaggerFragmentProducerComponent
import javax.inject.Inject

class FragmentProducer : Fragment() {

    @Inject
    lateinit var viewModel: ViewModelProducer2

    override fun onAttach(context: Context) {
        super.onAttach(context)
        DaggerFragmentProducerComponent
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
        return inflater.inflate(R.layout.fragment_a, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.button).setOnClickListener {
            viewModel.generateColor()
        }
    }

    override fun onDestroyView() {
        viewModel.disposeResources()
        super.onDestroyView()
    }
}