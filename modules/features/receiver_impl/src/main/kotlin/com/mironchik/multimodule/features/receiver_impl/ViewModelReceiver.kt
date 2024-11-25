package ru.otus.daggerhomework

import com.mironchik.multimodule.base.colors.ColorsController
import com.mironchik.multimodule.core.api.scopes.FeatureScope
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@FeatureScope
class ViewModelReceiver @Inject constructor(
    private val colorsController: ColorsController,
) {
    val colors: StateFlow<Int>
        get() = colorsController.color
}