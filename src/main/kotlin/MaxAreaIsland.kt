// 695

private fun maxAreaOfIsland(grid: Array<IntArray>): Int {
    var maxArea = 0
    val m = grid.size
    val n = grid[0].size
    for (i in 0 until m) {
        for (j in 0 until n) {
            if (grid[i][j] == 1) {
                val area = areaOfIsland(grid, i, j, m, n)
                if (area > maxArea)
                    maxArea = area
            }
        }
    }
    return maxArea
}

private fun areaOfIsland(grid: Array<IntArray>, i: Int, j: Int, m: Int, n: Int): Int {
    if (outOfBound(i, j, m, n) || grid[i][j] == 0)
        return 0
    grid[i][j] = 0// make initial island visited
    val left = areaOfIsland(grid, i, j - 1, m, n)
    val right = areaOfIsland(grid, i, j + 1, m, n)
    val top = areaOfIsland(grid, i - 1, j, m, n)
    val bottom = areaOfIsland(grid, i + 1, j, m, n)
    return 1+ left + right + top + bottom // plus 1 for initial island
}

private fun outOfBound(i: Int, j: Int, m: Int, n: Int): Boolean {
    return i < 0 || j < 0 || i > m - 1 || j > n - 1
}

fun main() {
    val input1 = arrayOf(
        intArrayOf(0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0),
        intArrayOf(0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0),
        intArrayOf(0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0),
        intArrayOf(0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0),
        intArrayOf(0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0),
        intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0),
        intArrayOf(0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0),
        intArrayOf(0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0)
    )
    val res = maxAreaOfIsland(input1)
    println(res)
}