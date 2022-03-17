package ru.otus.daggerhomework

import android.app.Application
import android.content.Context
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.internal.util.HalfSerializer.onNext
import io.reactivex.rxjava3.subjects.PublishSubject
import java.lang.RuntimeException
import javax.inject.Inject

class ViewModelReceiver  constructor(
     val context: Application,
     protected val publishSubject: PublishSubject<Int>
) : ViewModel() {
    sealed class Result {
        data class Success(val color: Int) : Result()
    }

    private val compositeDisposable = CompositeDisposable()
    private val _result= MutableLiveData<Result>()
    val result: LiveData<Result> = _result

    fun observeColors() {
        if (context !is Application) throw RuntimeException("Здесь нужен контекст апликейшена")

        compositeDisposable.add(this.publishSubject.subscribe {
            _result.value = Result.Success(it)
            Toast.makeText(this.context, "Color received " + it.toString(), Toast.LENGTH_LONG)
                .show()
        });

    }

    override fun onCleared() {
        compositeDisposable.clear()
    }
}

class ViewModelReceiverFactory(private val context: Application,private val publishSubject: PublishSubject<Int>) :
    ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        ViewModelReceiver(context,publishSubject) as T
}