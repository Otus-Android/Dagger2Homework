package ru.otus.daggerhomework

import android.app.Application
import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Named

class ViewModelReceiver @Inject constructor(
    @Named("AppContext") private val context: Context,
    private val mediator: Mediator
) : ViewModel() {

    private val disposable = CompositeDisposable()

    private val _color = MutableLiveData<Int>()
    val color get() = _color

    init {
        observeColors()
    }

    private fun observeColors() {
        if (context !is Application) throw RuntimeException("Здесь нужен контекст апликейшена")
        disposable.add(
        mediator
            .observeEvent()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(
                object : DisposableObserver<Int>() {

                    override fun onError(e: Throwable) {}

                    override fun onNext(t: Int) {
                        _color.value = t
                    }

                    override fun onComplete() {}
                }
            )
        )
    }

    override fun onCleared() {
        disposable.dispose()
    }

    class ViewModelReceiverFactory @Inject constructor(
        @Named("AppContext") private val context: Context,
        private val mediator: Mediator
    ) : ViewModelProvider.Factory {

        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return ViewModelReceiver(context, mediator) as T
        }
    }
}

