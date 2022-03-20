package ru.otus.daggerhomework

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.subjects.PublishSubject
import java.lang.RuntimeException
import javax.inject.Inject

class ViewModelProducer @Inject constructor(
    private val colorGenerator: ColorGenerator,
    private val context: Context,
    private val publishSubject: PublishSubject<Int>
) : ViewModel() {

    fun generateColor() {
        if (context !is FragmentActivity) throw RuntimeException("Здесь нужен контекст активити")
        publishSubject.onNext(this.colorGenerator.generateColor())
        Toast.makeText(context, "Color sent", Toast.LENGTH_LONG).show()
    }
}