package com.example.myapplication

import android.graphics.Color.WHITE
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumnFor
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.setContent
import com.example.myapplication.data.Cube
import com.example.myapplication.ui.AppColors
import com.example.myapplication.ui.MyApplicationTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val cube = Cube.newCube()

        setContent {
            MyApplicationTheme {
                Surface(color = MaterialTheme.colors.background) {
                    render(cube = cube)
                }
            }
        }
    }

    @Composable
    private fun render(cube: Cube) {
        Column {
            cube.surfaces.forEachIndexed { index, surface ->
                if (index > 0) {
                    Text(text = "-")
                }
                Text(text = surface.position.toString())
                LazyGridFor(items = surface.items, rowSize = cube.size) { item ->
                    Text(
                        text = item.toString(),
                        color = when (item) {
                            Cube.Colors.WHITE -> AppColors.white
                            Cube.Colors.GREEN -> AppColors.green
                            Cube.Colors.RED -> AppColors.red
                            Cube.Colors.BLUE -> AppColors.blue
                            Cube.Colors.ORANGE -> AppColors.orange
                            Cube.Colors.YELLOW -> AppColors.yellow
                        }
                    )
                }
            }
        }
    }
}


@Composable
private fun <T> LazyGridFor(
    items: List<T>,
    rowSize: Int = 1,
    itemContent: @Composable BoxScope.(T) -> Unit,
) {
    val rows = items.chunked(rowSize)
    LazyColumnFor(rows) { row ->
        Row(Modifier.fillParentMaxWidth()) {
            for ((index, item) in row.withIndex()) {
                Box(Modifier.fillMaxWidth(1f / (rowSize - index))) {
                    itemContent(item)
                }
            }
        }
    }
}