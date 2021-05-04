package com.example.movieaddiction

import com.example.movieaddiction.databinding.ActivityMainBinding
import com.google.accompanist.pager.ExperimentalPagerApi
import com.karleinstein.basemvvm.base.BaseActivity
import com.karleinstein.basemvvm.extension.addFragment
import com.karleinstein.basemvvm.utils.viewBinding

@ExperimentalPagerApi
class MainActivity : BaseActivity() {
    override val viewBinding: ActivityMainBinding by viewBinding(ActivityMainBinding::inflate)

    override fun bindView() {
        supportFragmentManager.addFragment(
            fragment = WelcomeFragment.newInstance(),
            container = R.id.root_content_view
        )
    }

    override fun setUpView() {

    }
}
