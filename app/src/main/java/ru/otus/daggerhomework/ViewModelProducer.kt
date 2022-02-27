package ru.otus.daggerhomework

import android.app.Activity
import android.content.Context
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.RuntimeException
import javax.inject.Inject

class ViewModelProducer (
    private val colorGenerator: ColorGenerator,
    private val context: Context
) : ViewModel() {

    private val _result= MutableLiveData<Result>()
    val result: LiveData<Result> = _result

    sealed class Result {
        data class Success(val color: Int) : Result()
    }

    fun generateColor() {
        if (context !is FragmentActivity) throw RuntimeException("Здесь нужен контекст активити")
        _result.value = Result.Success( this.colorGenerator.generateColor())
        Toast.makeText(context, "Color sent", Toast.LENGTH_LONG).show()
    }
}

class ViewModelProducerFactory(private val colorGenerator: ColorGenerator,private val context: Context) :
    ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        ViewModelProducer(colorGenerator,context) as T
}