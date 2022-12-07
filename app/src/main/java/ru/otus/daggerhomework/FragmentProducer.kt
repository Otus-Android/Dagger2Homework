package ru.otus.daggerhomework

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import ru.otus.daggerhomework.di.ActivityContext
import ru.otus.daggerhomework.di.ApplicationContext
import ru.otus.daggerhomework.di.components.DaggerFragmentProducerComponent
import ru.otus.daggerhomework.di.components.FragmentProducerComponent
import javax.inject.Inject
import javax.inject.Provider

class FragmentProducer : Fragment() {

    @Inject
    lateinit var dataKeeper: Provider<IDataKeeper>

    @Inject
    @ActivityContext
    lateinit var activityContext: Context

    lateinit var fragmentProducerComponent: FragmentProducerComponent
    private val colorGenerator = ColorGeneratorImpl()
    lateinit var viewModelProducer: ViewModelProducer

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val activityComponent = (requireActivity() as MainActivity).activityComponent
        fragmentProducerComponent = DaggerFragmentProducerComponent
            .builder()
            .activityComponent(activityComponent)
            .build()

        fragmentProducerComponent.inject(this)
        viewModelProducer = ViewModelProducer(
            colorGenerator,
            activityContext,
            dataKeeper.get()
        )

        return inflater.inflate(R.layout.fragment_a, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.button).setOnClickListener {
            lifecycleScope.launch {
                //отправить результат через livedata в другой фрагмент
                viewModelProducer.generateColor()
            }
        }
    }
}