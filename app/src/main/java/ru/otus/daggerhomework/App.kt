package ru.otus.daggerhomework

import android.app.Application
import ru.otus.daggerhomework.di.DaggerAppComponent

class App : Application() {
    val appComponent = DaggerAppComponent.factory().create(this)
}

object ComponentStore {
    private val map = mutableMapOf<String, ComponentHolder<out Any>>()

    @Suppress("UNCHECKED_CAST")
    fun <T : Any> get(key: String, factory: (() -> T)): ComponentHolder<T> {
        var component = map[key]
        if (component == null) {
            component = ComponentHolder(key, factory.invoke())
            map[key] = component
        }
        return component as ComponentHolder<T>
    }

    fun delete(componentHolder: ComponentHolder<out Any>) {
        map.remove(componentHolder.key)
    }
}
data class ComponentHolder<T>(
    val key: String,
    val component: T
)