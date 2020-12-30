package com.example.myapplication.ui

data class UiCube(
    val size: Int,
    val front: Surface,
    val left: Surface,
    val right: Surface,
    val up: Surface,
    val down: Surface,
    val back: Surface
) {
    enum class Colors {
        WHITE,
        GREEN,
        RED,
        BLUE,
        ORANGE,
        YELLOW
    }

    class Surface(val cubeSize: Int, private val squares: List<Colors>) {
        fun get(x: Int, y: Int): Colors {
            return squares[y * cubeSize + x]
        }
    }


    companion object {
        fun solvedCube(size: Int) = UiCube(
            size = size,
            front = Surface(size, MutableList(size * size) { Colors.WHITE }),
            left = Surface(size, MutableList(size * size) { Colors.GREEN }),
            right = Surface(size, MutableList(size * size) { Colors.RED }),
            up = Surface(size, MutableList(size * size) { Colors.BLUE }),
            down = Surface(size, MutableList(size * size) { Colors.ORANGE }),
            back = Surface(size, MutableList(size * size) { Colors.YELLOW })
        )
    }
}