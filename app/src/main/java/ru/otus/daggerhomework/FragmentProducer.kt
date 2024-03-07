package ru.otus.daggerhomework

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import io.reactivex.rxjava3.subjects.PublishSubject
import javax.inject.Inject

class FragmentProducer : Fragment() {

    private lateinit var viewModelProducer: ViewModelProducer

    @Inject
    lateinit var mainActivityContext: MainActivity

    @Inject
    lateinit var subject: PublishSubject<Int>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val activity = requireActivity() as MainActivity
        val application = activity.application as App
        DaggerFragmentProducerComponent.factory().create(
            mainActivityComponent = activity.getMainActivityComponent(),
            applicationComponent = application.appComponent
        ).inject(this)
        viewModelProducer = ViewModelProducer(
            colorGenerator = ColorGeneratorImpl(),
            context = mainActivityContext,
            subject = subject
        )

        return inflater.inflate(R.layout.fragment_a, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.button).setOnClickListener {
            viewModelProducer.generateColor()
        }
    }
}