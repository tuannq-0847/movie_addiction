package com.example.movieaddiction.ui.composables.viewmodels

import com.example.movieaddiction.utils.Karl
import com.karleinstein.basemvvm.base.BaseViewModel

class WelcomeViewModel : BaseViewModel() {

    fun onPagerChange(page: Int) {
        Karl.d("page change: $page")
    }

    fun calculateDirection(startPoint: Float, endPoint: Float) {
        if (startPoint - endPoint > 0) {
            //left to right

        } else {
            //right to left

        }
    }
}
