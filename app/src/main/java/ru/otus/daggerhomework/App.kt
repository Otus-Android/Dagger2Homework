package ru.otus.daggerhomework

import android.app.Application

class App :Application() {
 val applicationComponent = DaggerApplicationComponent.builder()
    .build()
   // applicationComponent.inject(this)


}