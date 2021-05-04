package com.example.movieaddiction

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.movieaddiction.databinding.FragmentWelcomeBinding
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState
import com.karleinstein.basemvvm.base.BaseFragment
import com.karleinstein.basemvvm.data.transfer.DataTransfer
import com.karleinstein.basemvvm.utils.viewBinding

@ExperimentalPagerApi
class WelcomeFragment : BaseFragment(R.layout.fragment_welcome) {
    override val viewBinding: FragmentWelcomeBinding by viewBinding(FragmentWelcomeBinding::bind)

    override fun bindView() {
        Karl.d("bind....")
    }

    override fun setUpView() {
        Karl.d("setUpView....")
        viewBinding.composeView.setContent {
            LoadUI()
        }
    }

    @Preview
    @Composable
    fun LoadUI() {
        Column(
            modifier = Modifier.background(color = Color.White).fillMaxSize(),
        ) {
            // Display 3 items
            val pagerState = rememberPagerState(pageCount = 3)

            HorizontalPager(state = pagerState) {
                Image(
                    painter = painterResource(R.drawable.ic_launcher_background),
                    contentDescription = null,
                    modifier = Modifier.fillMaxWidth()
                        .height(300.dp),
                    contentScale = ContentScale.Crop
                )
            }

            HorizontalPagerIndicator(
                pagerState = pagerState,
                modifier = Modifier.align(Alignment.CenterHorizontally)
                    .padding(16.dp),
                inactiveColor = Color.LightGray,
                indicatorWidth = 10.dp,
                indicatorHeight = 10.dp,
                spacing = 10.dp,
                activeColor = Color.Blue
            )
        }
    }

    companion object {

        fun newInstance(vararg dataTransfer: DataTransfer) =
            newInstance(entity = WelcomeFragment(), dataTransfer = dataTransfer)
    }
}