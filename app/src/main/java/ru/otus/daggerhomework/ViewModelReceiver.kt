package ru.otus.daggerhomework

import android.app.Application
import android.content.Context
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.subjects.PublishSubject
import javax.inject.Inject

class ViewModelReceiver @Inject constructor(
    @ApplicationContext
    private val context: Context,
    private val observer: PublishSubject<Int>
) : ViewModel() {

    private val _color: MutableLiveData<Int> = MutableLiveData()
    val color: LiveData<Int> = _color

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    fun observeColors() {
        if (context !is Application) throw RuntimeException("Здесь нужен контекст апликейшена")
        Toast.makeText(context, "Color received", Toast.LENGTH_LONG).show()
        compositeDisposable.add(observer.subscribeBy {
            _color.value = it
        })
    }

    override fun onCleared() {
        super.onCleared()

        compositeDisposable.dispose()
    }
}