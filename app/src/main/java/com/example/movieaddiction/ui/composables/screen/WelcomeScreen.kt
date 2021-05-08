package com.example.movieaddiction.ui.composables.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import androidx.navigation.compose.popUpTo
import com.example.movieaddiction.R
import com.example.movieaddiction.model.PagerWelcomeData
import com.example.movieaddiction.ui.composables.navigation.MovieAddictionScreen
import com.example.movieaddiction.ui.composables.viewmodels.WelcomeViewModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.flow.collect
import org.koin.androidx.compose.getViewModel

@ExperimentalPagerApi
@Composable
fun WelcomeScreen(navController: NavController) {
    val welcomeViewModel = getViewModel<WelcomeViewModel>()
    ConstraintLayout(
        modifier = Modifier
            .background(color = colorResource(id = R.color.white_1))
            .fillMaxSize(),
    ) {
        val btmGuideline = createGuidelineFromBottom(0.4f)
        val (horizontalPager, textWelcome, row) = createRefs()
        // Display 3 items
        val pagerState = rememberPagerState(pageCount = 3)
        val pagesData = listOf(
            PagerWelcomeData(
                resource = R.drawable.cassette_vintage,
                subTitle = stringResource(id = R.string.welcome_1),
                inactiveColorIndicator = R.color.white_2,
                activeColorIndicator = R.color.blue_1
            ),
            PagerWelcomeData(
                resource = R.drawable.cassette_retro_hand_welcome,
                subTitle = "cassette_vintage",
                inactiveColorIndicator = R.color.white_2,
                activeColorIndicator = R.color.blue_1
            ),
            PagerWelcomeData(
                resource = R.drawable.cassette_retro_hand_welcome,
                subTitle = "cassette_retro_hand_welcome 123",
                inactiveColorIndicator = R.color.white_2,
                activeColorIndicator = R.color.blue_1
            )
        )

        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(horizontalPager) {
                    linkTo(
                        top = parent.top,
                        start = parent.start,
                        end = parent.end,
                        bottom = textWelcome.top
                    )
                }
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) { pager ->
            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                Image(
                    painter = painterResource(pagesData[pager].resource),
                    contentDescription = null,
                    modifier = Modifier
                        .size(400.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop,
                )
            }
        }
        LaunchedEffect(pagerState) {
            snapshotFlow { pagerState.currentPage }.collect { page ->
                welcomeViewModel.onPagerChange(page)
            }
        }
        Text(
            buildAnnotatedString {
                withStyle(style = SpanStyle(color = colorResource(id = R.color.blue_2))) {
                    append(text = stringResource(id = R.string.welcome_1) + " ")
                }
                withStyle(
                    style = SpanStyle(
                        color = colorResource(id = R.color.blue_1),
                        fontWeight = FontWeight.Bold
                    )
                ) {
                    append(text = stringResource(id = R.string.welcome_app_name))
                }
                withStyle(style = SpanStyle(color = colorResource(id = R.color.blue_2))) {
                    append(text = stringResource(id = R.string.welcome_1_line_2))
                }
            }, fontSize = 20.sp, textAlign = TextAlign.Center, modifier = Modifier
                .constrainAs(textWelcome) {
                    linkTo(
                        top = horizontalPager.bottom,
                        start = parent.start,
                        end = parent.end,
                        bottom = btmGuideline,
                    )
                })
        ConstraintLayout(
            modifier = Modifier
                .constrainAs(row) {
                    linkTo(
                        top = textWelcome.bottom,
                        start = parent.start,
                        end = parent.end,
                        bottom = parent.bottom
                    )
                }
                .fillMaxWidth()
                .padding(top = 16.dp, bottom = 16.dp)
        ) {
            val (login, indicators, skip) = createRefs()
            Button(
                onClick = {
                    navController.navigate(MovieAddictionScreen.LOGIN_ROUTE.name)
                },
                border = BorderStroke(2.dp, color = colorResource(id = R.color.blue_2)),
                colors = ButtonDefaults.outlinedButtonColors(backgroundColor = colorResource(id = R.color.white_2)),
                shape = RoundedCornerShape(50),
                modifier = Modifier
                    .width(100.dp)
                    .height(38.dp)
                    .constrainAs(login) {
                        linkTo(
                            top = parent.top,
                            start = parent.start,
                            end = indicators.start,
                            bottom = parent.bottom
                        )
                    }
            ) {
                Text(
                    text = stringResource(id = R.string.login),
                    color = colorResource(id = R.color.blue_2)
                )
            }
            HorizontalPagerIndicator(
                pagerState = pagerState,
                modifier = Modifier
                    .padding(16.dp)
                    .constrainAs(indicators) {
                        linkTo(
                            top = parent.top,
                            start = login.end,
                            end = skip.start,
                            bottom = parent.bottom
                        )
                    },
                inactiveColor = colorResource(id = pagesData[pagerState.currentPage].inactiveColorIndicator),
                indicatorWidth = 10.dp,
                indicatorHeight = 10.dp,
                spacing = 10.dp,
                activeColor = colorResource(id = pagesData[pagerState.currentPage].activeColorIndicator)
            )
            Button(
                onClick = { },
                colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.blue_2)),
                shape = RoundedCornerShape(50),
                modifier = Modifier
                    .width(100.dp)
                    .height(38.dp)
                    .constrainAs(skip) {
                        linkTo(
                            top = parent.top,
                            start = indicators.end,
                            end = parent.end,
                            bottom = parent.bottom
                        )
                    },
            ) {
                Text(
                    text = stringResource(id = R.string.skip),
                    color = colorResource(id = R.color.white_2)
                )
            }
        }
    }
}
