// 1254
// https://www.youtube.com/watch?v=MnD8KhBHgRo

fun closedIsland(grid: Array<IntArray>): Int {
    val m = grid.size
    val n = grid[0].size
    var closedIslands = 0

    for (i in 1 until m - 1) {
        for (j in 1 until n - 1) {
            if (grid[i][j] == 0 && isClosedIsland(grid, i, j, m, n))
                closedIslands++
        }
    }
    return closedIslands
}

private fun isClosedIsland(grid: Array<IntArray>, i: Int, j: Int, m: Int, n: Int): Boolean {
    // 0 == land
    // 1 == water
    // -1 ==visited
    if (grid[i][j] == -1 || grid[i][j] == 1) return true // Visited or Water, part of our island
    if (isInPerimeter(i, j, m, n)) return false // In Edge, not closed island
    grid[i][j] = -1 // Mark current point visited
    val left = isClosedIsland(grid, i, j - 1, m, n) // Left
    val right = isClosedIsland(grid, i, j + 1, m, n) // Right
    val top = isClosedIsland(grid, i - 1, j, m, n) // Top
    val bottom = isClosedIsland(grid, i + 1, j, m, n) // Bottom
    return left && right && top && bottom
}

private fun isInPerimeter(i: Int, j: Int, m: Int, n: Int): Boolean {
    return i == 0 || j == 0 || i == m - 1 || j == n - 1
}

fun main() {
    val input1 = arrayOf(
        intArrayOf(1, 1, 1, 1, 1, 1, 1, 0),
        intArrayOf(1, 0, 0, 0, 0, 1, 1, 0),
        intArrayOf(1, 0, 1, 0, 1, 1, 1, 0),
        intArrayOf(1, 0, 0, 0, 0, 1, 0, 1),
        intArrayOf(1, 1, 1, 1, 1, 1, 1, 0)
    )
    val res = closedIsland(input1)
    println(res)
}
