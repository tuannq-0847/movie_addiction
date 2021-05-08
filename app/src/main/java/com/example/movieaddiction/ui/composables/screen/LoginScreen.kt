package com.example.movieaddiction.ui.composables.screen

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.example.movieaddiction.R
import com.example.movieaddiction.ui.composables.navigation.MovieAddictionScreen

@Composable
fun LoginScreen(navController: NavController) {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.blue_2))
            .padding(32.dp)
    ) {
        val (text, gg, fb, skip) = createRefs()
        val btmGuideline = createGuidelineFromBottom(0.4f)
        createVerticalChain(gg, fb, skip, chainStyle = ChainStyle.Packed)
        Text(buildAnnotatedString {
            withStyle(style = ParagraphStyle(lineHeight = 25.sp)) {
                withStyle(
                    style = SpanStyle(
                        color = colorResource(id = R.color.white_1),
                        fontWeight = FontWeight.Bold,
                        fontSize = 30.sp
                    )
                ) {
                    append("Cinema Addiction\n\n")
                }
                withStyle(
                    style = SpanStyle(
                        color = colorResource(id = R.color.white_2),
                        fontSize = 20.sp
                    )
                ) {
                    append("Manage your favorite move\nshare to everyone")
                }
            }
        }, modifier = Modifier.constrainAs(text) {
            start.linkTo(gg.start)
            bottom.linkTo(btmGuideline)
        })
        Button(onClick = { /*TODO*/ },
            border = BorderStroke(1.dp, color = colorResource(id = R.color.white_1)),
            colors = ButtonDefaults.outlinedButtonColors(backgroundColor = colorResource(id = R.color.white_1)),
            shape = RoundedCornerShape(50),
            modifier = Modifier
                .width(400.dp)
                .padding(bottom = 16.dp)
                .constrainAs(gg) {
                    top.linkTo(text.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(fb.top)
                }) {
            Text(
                text = "Sign in with Google", color = colorResource(id = R.color.blue_1),
                modifier = Modifier.padding(8.dp)
            )
        }
        Button(onClick = { /*TODO*/ },
            border = BorderStroke(1.dp, color = colorResource(id = R.color.white_2)),
            colors = ButtonDefaults.outlinedButtonColors(backgroundColor = colorResource(id = R.color.blue_2)),
            shape = RoundedCornerShape(50),
            modifier = Modifier
                .width(400.dp)
                .padding(bottom = 16.dp)
                .constrainAs(fb) {
                    top.linkTo(gg.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(skip.top)
                }) {
            Text(
                text = "Sign in with Facebook",
                color = colorResource(id = R.color.white_2),
                modifier = Modifier.padding(8.dp)
            )
        }
        TextButton(onClick = {
            navController.navigate(MovieAddictionScreen.HOME_ROUTE.name)
        },
            modifier = Modifier.constrainAs(skip) {
                top.linkTo(fb.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                bottom.linkTo(parent.bottom)
            }) {
            Text(
                text = "Skip",
                color = colorResource(id = R.color.white_2),
            )
        }
    }
}
