// 694
// https://www.youtube.com/watch?v=c1ZxUOHlulo

private fun distinctIslands(grid: Array<IntArray>): Int {
    val islands = HashSet<String>()
    val m = grid.size
    val n = grid[0].size
    for (i in 0 until m) {
        for (j in 0 until n) {
            if (grid[i][j] == 1) {
                val island = generateIslandIdentity(grid, i, j, m, n, "X")
                println(island)
                islands.add(island)
            }
        }
    }
    return islands.size
}

fun generateIslandIdentity(grid: Array<IntArray>, i: Int, j: Int, m: Int, n: Int, identifier: String): String {
    if (outOfBound(i, j, m, n) || grid[i][j] == 0)
        return "O"
    grid[i][j] = 0
    val left = generateIslandIdentity(grid, i, j - 1, m, n, "L")
    val right = generateIslandIdentity(grid, i, j + 1, m, n, "R")
    val top = generateIslandIdentity(grid, i - 1, j, m, n, "T")
    val bottom = generateIslandIdentity(grid, i + 1, j, m, n, "B")
    return identifier + left + right + top + bottom
}

private fun outOfBound(i: Int, j: Int, m: Int, n: Int): Boolean {
    return i < 0 || j < 0 || i > m - 1 || j > n - 1
}

fun main() {
    val input2 = arrayOf(
        intArrayOf(1, 1, 0, 1, 0),
        intArrayOf(1, 1, 0, 0, 0),
        intArrayOf(0, 0, 0, 1, 1),
        intArrayOf(0, 0, 0, 1, 1)
    )
    val result = distinctIslands(input2)
    println(result)
}