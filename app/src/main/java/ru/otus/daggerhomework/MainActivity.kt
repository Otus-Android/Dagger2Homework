package ru.otus.daggerhomework

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.otus.daggerhomework.di.activity.ActivityComponent
import ru.otus.daggerhomework.di.activity.DaggerActivityComponent
import ru.otus.daggerhomework.di.application.ApplicationContext
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

  @Inject
  @ApplicationContext
  lateinit var appContext: Context

  private var activityComponent: ActivityComponent? = null

  fun getActivityComponent(): ActivityComponent? {
    return activityComponent
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    activityComponent = DaggerActivityComponent.factory().create(
      this,
      (application as App).getApplicationComponent()
    )
    activityComponent?.inject(this)
  }

  override fun onDestroy() {
    super.onDestroy()
    activityComponent = null
  }
}