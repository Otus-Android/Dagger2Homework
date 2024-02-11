package ru.otus.daggerhomework

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

  lateinit var stateDependency: StateFlowDependency

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    stateDependency =
        DaggerMainActivityComponent.factory().getComponent(this, (application as App).appComponent)
    if (savedInstanceState == null) {
      supportFragmentManager
          .beginTransaction()
          .add(R.id.container1, FragmentProducer())
          .add(R.id.container2, FragmentReceiver())
          .commit()
    }
  }
}
