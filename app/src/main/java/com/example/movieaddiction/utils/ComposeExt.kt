package com.example.movieaddiction.utils

import androidx.constraintlayout.compose.ConstrainScope
import androidx.constraintlayout.compose.ConstraintLayoutBaseScope

fun ConstrainScope.linkToM(
    top: ConstraintLayoutBaseScope.HorizontalAnchor? = parent.top,
    start: ConstraintLayoutBaseScope.VerticalAnchor? = parent.start,
    end: ConstraintLayoutBaseScope.VerticalAnchor? = parent.end,
    bottom: ConstraintLayoutBaseScope.HorizontalAnchor? = parent.bottom
) {
    this.let {
        if (top != null) {
            it.top.linkTo(top)
        }
        if (start != null) {
            it.start.linkTo(start)
        }
        if (end != null) {
            it.end.linkTo(end)
        }
        if (bottom != null) {
            it.bottom.linkTo(bottom)
        }
    }
}
