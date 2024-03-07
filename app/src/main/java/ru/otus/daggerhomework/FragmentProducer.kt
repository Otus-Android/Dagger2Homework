package ru.otus.daggerhomework

import android.content.Context
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
    @MainActivityContext
    lateinit var mainActivityContext: Context

    @Inject
    lateinit var subject: PublishSubject<Int>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val activity = requireActivity() as MainActivityComponentInterface
        DaggerFragmentProducerComponent.factory().create(
            mainActivityComponent = activity.getComponent()
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
            //отправить результат через livedata в другой фрагмент
        }
    }
}