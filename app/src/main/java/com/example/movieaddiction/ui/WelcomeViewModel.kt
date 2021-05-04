package com.example.movieaddiction.ui

import com.karleinstein.basemvvm.base.BaseViewModel

class WelcomeViewModel : BaseViewModel() {

    fun onPagerChange(page: Int) {

    }

    fun calculateDirection(startPoint: Float, endPoint: Float) {
        if (startPoint - endPoint > 0) {
            //left to right

        } else {
            //right to left

        }
    }
}
