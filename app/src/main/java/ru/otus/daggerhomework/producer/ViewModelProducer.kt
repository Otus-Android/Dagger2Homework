package ru.otus.daggerhomework.producer

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import dagger.BindsInstance
import ru.otus.daggerhomework.ColorGenerator
import ru.otus.daggerhomework.Event
import ru.otus.daggerhomework.MutableEventObservable
import ru.otus.daggerhomework.producer.di.FragmentProducerComponent
import javax.inject.Inject
import javax.inject.Named

class ViewModelProducer @Inject constructor(
    private val colorGenerator: ColorGenerator,
    @Named(FragmentProducerComponent.ACTIVITY_CONTEXT_QUALIFIER) private val context: Context,
    private val eventObservable: MutableEventObservable
) : ViewModel() {

    fun generateColor() {
        if (context !is FragmentActivity) throw RuntimeException("Здесь нужен контекст активити")
        Toast.makeText(context, "Color sent", Toast.LENGTH_LONG).show()
        eventObservable.post(Event.ShowColor(colorGenerator.generateColor()))
    }
}