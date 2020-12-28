package com.example.myapplication.ui

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

object AppColors {
    val purple200 = Color(0xFFBB86FC)
    val purple500 = Color(0xFF6200EE)
    val purple700 = Color(0xFF3700B3)
    val teal200 = Color(0xFF03DAC5)

    val white = Color(0xFFFFFFFF)
    val green = Color(0xFF00FF00)
    val red = Color(0xFFFF0000)
    val blue = Color(0xFF0000FF)
    val orange = Color(0xFFFFA500)
    val yellow= Color(0xFFFFFF00)
}

object AppType {
    val typography = Typography(
        body1 = TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp
        ),
        button = TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.W500,
            fontSize = 14.sp
        ),
        caption = TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Normal,
            fontSize = 12.sp
        )
    )
}

object AppPalette {
    val DarkColorPalette = darkColors(
        primary = AppColors.purple200,
        primaryVariant = AppColors.purple700,
        secondary = AppColors.teal200
    )

    val LightColorPalette = lightColors(
        primary = AppColors.purple500,
        primaryVariant = AppColors.purple700,
        secondary = AppColors.teal200
    )

}

object AppShape {
    val shapes = Shapes(
        small = RoundedCornerShape(4.dp),
        medium = RoundedCornerShape(4.dp),
        large = RoundedCornerShape(0.dp)
    )
}

@Composable
fun MyApplicationTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        AppPalette.DarkColorPalette
    } else {
        AppPalette.LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = AppType.typography,
        shapes = AppShape.shapes,
        content = content
    )
}
