package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.AppColors
import com.example.myapplication.ui.MyApplicationTheme
import com.example.myapplication.ui.UiCube

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val cube = UiCube.solvedCube(3)

        setContent {
            MyApplicationTheme {
                Surface(color = MaterialTheme.colors.background) {
                    MainActivityRenderer.Render(cube)
                }
            }
        }
    }
}

object MainActivityRenderer {

    @Composable
    fun Render(cube: UiCube) {
        Column(verticalArrangement = Arrangement.Center) {
            for (i in 0 until 4) {
                Row(Modifier.weight(1f, false)) {
                    for (j in 0 until 3) {
                        Column(
                            Modifier
                                .aspectRatio(1f)
                                .weight(1f)
                        ) {
                            val face = when (i to j) {
                                0 to 1 -> cube.up
                                1 to 0 -> cube.left
                                1 to 1 -> cube.front
                                1 to 2 -> cube.right
                                2 to 1 -> cube.down
                                3 to 1 -> cube.back
                                else -> null
                            }
                            if (face == null) {
                                FakeSurface()
                            } else {
                                CubeSurface(face)
                            }
                        }
                    }
                }
            }
        }
    }

    @Composable
    private fun ColumnScope.CubeSurface(source: UiCube.Surface) {
        for (i in 0 until source.cubeSize) {
            Row(Modifier.fillMaxSize().weight(1f)) {
                for (j in 0 until source.cubeSize) {
                    Box(
                        Modifier
                            .background(source.get(i, j).resolve())
                            .fillMaxSize()
                            .weight(1f)
                            .border(
                                BorderStroke(
                                    2.dp,
                                    Color.DarkGray
                                )
                            )
                    )
                }
            }
        }
    }

    @Composable
    private fun ColumnScope.FakeSurface() {
        Box(
            Modifier
                .fillMaxSize()
                .weight(1f)
        )
    }

    private fun UiCube.Colors.resolve(): Color {
        return when (this) {
            UiCube.Colors.WHITE -> Color.White
            UiCube.Colors.GREEN -> Color.Green
            UiCube.Colors.RED -> Color.Red
            UiCube.Colors.BLUE -> Color.Blue
            UiCube.Colors.ORANGE -> AppColors.orange
            UiCube.Colors.YELLOW -> Color.Yellow
        }
    }
}

@Preview
@Composable
fun PreviewGreeting() {
    MainActivityRenderer.Render(UiCube.solvedCube(3))
}
