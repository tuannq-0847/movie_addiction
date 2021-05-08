package com.example.movieaddiction

import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.movieaddiction.databinding.ActivityMainBinding
import com.example.movieaddiction.ui.composables.navigation.AppNavigation
import com.google.accompanist.pager.ExperimentalPagerApi
import com.karleinstein.basemvvm.base.BaseActivity
import com.karleinstein.basemvvm.extension.addFragment
import com.karleinstein.basemvvm.utils.viewBinding

@ExperimentalPagerApi
class MainActivity : BaseActivity() {
    override val viewBinding: ActivityMainBinding by viewBinding(ActivityMainBinding::inflate)

    override fun bindView() {
        setContent {
            val navHostController = rememberNavController()
            AppNavigation(navController = navHostController)
        }
    }

    override fun setUpView() {

    }
}
