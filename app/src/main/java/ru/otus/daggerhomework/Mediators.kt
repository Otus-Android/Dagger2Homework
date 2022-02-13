package ru.otus.daggerhomework

import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import javax.inject.Inject

interface Mediator {
    fun sendEvent(event: Int)
    fun observeEvent(): Observable<Int>
}

class MediatorImpl @Inject constructor() : Mediator {
    private val subject: PublishSubject<Int> = PublishSubject.create()
    override fun sendEvent(event: Int) {
        subject.onNext(event)
    }

    override fun observeEvent(): Observable<Int> {
        return subject.hide()
    }
}
