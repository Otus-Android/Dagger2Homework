package com.mironchik.multimodule.features.producer_impl

import androidx.lifecycle.ViewModel
import com.mironchik.multimodule.base.colors.ColorsController
import com.mironchik.multimodule.base.colors.ColorsGenerator
import com.mironchik.multimodule.core.api.scopes.FeatureScope
import javax.inject.Inject

@FeatureScope
class ViewModelProducer @Inject constructor(
    private val colorsController: ColorsController,
    private val colorGenerator: ColorsGenerator,
): ViewModel() {
    fun generateColor() {
        colorsController.updateColor(colorGenerator.generateColor())
    }
}