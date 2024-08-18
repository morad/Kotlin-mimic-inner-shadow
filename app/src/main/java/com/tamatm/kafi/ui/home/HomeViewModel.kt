package com.tamatm.kafi.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

data class BoxProperties(
    val hasShadow: Boolean,
    val shadowRadius: Int,
    val shadowIsInner: Boolean,
    val verticalPadding: Int
)

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is whole Fragment"
    }

    val text: LiveData<String> = _text

    val firstBox = BoxProperties(
        hasShadow = true,
        shadowRadius = 3,
        shadowIsInner = false,
        verticalPadding = 20
    )

    val secondBox = BoxProperties(
        hasShadow = true,
        shadowRadius = 3,
        shadowIsInner = true,
        verticalPadding = 20
    )

    val thirdBox = BoxProperties(
        hasShadow = true,
        shadowRadius = 3,
        shadowIsInner = false,
        verticalPadding = 0  // No vertical padding specified for the third box
    )
}