package ru.otus.daggerhomework

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import ru.otus.daggerhomework.di.activity.ActivityComponent
import ru.otus.daggerhomework.di.quialifiers.ActivityContext
import ru.otus.daggerhomework.di.quialifiers.ApplicationContext
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

  @Inject
  @ApplicationContext
  lateinit var context: Context

  @Inject
  @ActivityContext
  lateinit var activityContext: Context

  private var activityComponent: ActivityComponent? = null

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    activityComponent =
      (application as App).applicationComponent.mainActivityComponentFactory().create(this)
    activityComponent?.inject(this)
    setContentView(R.layout.activity_main)
  }

  override fun onDestroy() {
    super.onDestroy()
    activityComponent = null
  }

  fun getActivityComponent(): ActivityComponent? {
    return activityComponent
  }

}