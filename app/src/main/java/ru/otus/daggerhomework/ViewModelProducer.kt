package ru.otus.daggerhomework

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.subjects.PublishSubject

class ViewModelProducer(
    private val colorGenerator: ColorGenerator,
    private val context: Context,
    private val subject: PublishSubject<Int>
): ViewModel() {


    fun generateColor() {
        if (context !is FragmentActivity) throw RuntimeException("Здесь нужен контекст активити")
        Toast.makeText(context, "Color sent", Toast.LENGTH_LONG).show()
        subject.onNext(colorGenerator.generateColor())
    }
}