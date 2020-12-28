package com.example.myapplication.data

/**
 *
 *                   +-----------------+
 *                   |                 |
 *                   |                 |
 *                   |       UP        |
 *                   |                 |
 *                   |                 |
 *                   |                 |
 *                   +-----------------+
 * +-----------------+-----------------+-----------------+-----------------+
 * |                 |                 |                 |                 |
 * |                 |                 |                 |                 |
 * |      LEFT       |      FRONT      |      RIGHT      |      BACK       |
 * |                 |                 |                 |                 |
 * |                 |                 |                 |                 |
 * |                 |                 |                 |                 |
 * +-----------------+-----------------+-----------------+-----------------+
 *                   |                 |
 *                   |                 |
 *                   |     BOTTOM      |
 *                   |                 |
 *                   |                 |
 *                   |                 |
 *                   +-----------------+
 */
class Cube private constructor() {

    private val front = Surface.newSurface(SurfacePosition.FRONT, Colors.WHITE, CUBE_SIZE)
    private val left = Surface.newSurface(SurfacePosition.LEFT, Colors.GREEN, CUBE_SIZE)
    private val right = Surface.newSurface(SurfacePosition.RIGHT, Colors.RED, CUBE_SIZE)
    private val up = Surface.newSurface(SurfacePosition.UP, Colors.BLUE, CUBE_SIZE)
    private val down = Surface.newSurface(SurfacePosition.DOWN, Colors.ORANGE, CUBE_SIZE)
    private val back = Surface.newSurface(SurfacePosition.BACK, Colors.YELLOW, CUBE_SIZE)

    val size = CUBE_SIZE
    val surfaces = listOf(front, left, right, up, down, back)

    enum class Colors {
        WHITE,
        GREEN,
        RED,
        BLUE,
        ORANGE,
        YELLOW
    }

    enum class SurfacePosition {
        FRONT,
        LEFT,
        RIGHT,
        UP,
        DOWN,
        BACK
    }

    data class Surface(
        val items: MutableList<Colors>,
        val position: SurfacePosition,
        private val cubeSize: Int
    ) {
        fun get(x: Int, y: Int): Colors {
            return items[y * cubeSize + x]
        }

        companion object {
            fun newSurface(
                position: SurfacePosition,
                initialColor: Colors,
                size: Int
            ): Surface {
                return Surface(
                    items = MutableList(size * size) { initialColor },
                    cubeSize = size,
                    position = position
                )
            }
        }
    }

    companion object {
        const val CUBE_SIZE = 3

        fun newCube(): Cube {
            return Cube()
        }
    }
}