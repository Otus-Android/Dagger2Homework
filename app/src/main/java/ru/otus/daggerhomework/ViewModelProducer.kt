package ru.otus.daggerhomework

import android.app.Activity
import android.content.Context
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import io.reactivex.rxjava3.subjects.PublishSubject
import java.lang.RuntimeException
import javax.inject.Inject

class ViewModelProducer (
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

class ViewModelProducerFactory(private val colorGenerator: ColorGenerator,private val context: Context,private val publishSubject: PublishSubject<Int>) :
    ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        ViewModelProducer(colorGenerator,context,publishSubject) as T
}