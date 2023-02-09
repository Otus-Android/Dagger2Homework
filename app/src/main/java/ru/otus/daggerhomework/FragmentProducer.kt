package ru.otus.daggerhomework

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import ru.otus.daggerhomework.di.FragmentProducerComponent
import javax.inject.Inject

class FragmentProducer : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_a, container, false)
    }

    @Inject lateinit var produceLiveData: MutableLiveData<Int>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (requireActivity() as MainActivity).mainActivityComponent.fragmentProducerComponent().build().inject(this)

        view.findViewById<Button>(R.id.button).setOnClickListener {
            produceLiveData.postValue(123)
            //отправить результат через livedata в другой фрагмент
        }
    }
}