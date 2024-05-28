package ru.otus.daggerhomework

interface IObserver<T> {
  fun notify(data: T)
}

interface IColorObservable {
  fun add(observer: IObserver<Int>)

  fun remove(observer: IObserver<Int>)

  fun notify(data: Int)
}

class ColorObservableImpl: IColorObservable {
  private val observers = mutableListOf<IObserver<Int>>()

  override fun add(observer: IObserver<Int>) {
    observers.add(observer)
  }

  override fun remove(observer: IObserver<Int>) {
    observers.remove(observer)
  }

  override fun notify(data: Int) {
    observers.forEach { it.notify(data) }
  }
}