// 200
// BFS

private   data class Point(val x: Int, val y: Int) {
    fun doLeft(grid: Array<CharArray>, colSize: Int, nextPoints: ArrayDeque<Point>) {
        if (y - 1 in 0 until colSize && grid[x][y - 1] == '1') {
            nextPoints.add(Point(x, y - 1))
            grid[x][y - 1] = '0'
        }
    }

    fun doRight(grid: Array<CharArray>, colSize: Int, nextPoints: ArrayDeque<Point>) {
        if (y + 1 in 0 until colSize && grid[x][y + 1] == '1') {
            nextPoints.add(Point(x, y + 1))
            grid[x][y + 1] = '0'
        }
    }

    fun doTop(grid: Array<CharArray>, rowSize: Int, nextPoints: ArrayDeque<Point>) {
        if (x - 1 in 0 until rowSize && grid[x - 1][y] == '1') {
            nextPoints.add(Point(x - 1, y))
            grid[x - 1][y] = '0'
        }
    }

    fun doBottom(grid: Array<CharArray>, rowSize: Int, nextPoints: ArrayDeque<Point>) {
        if (x + 1 in 0 until rowSize && grid[x + 1][y] == '1') {
            nextPoints.add(Point(x + 1, y))
            grid[x + 1][y] = '0'
        }
    }
}

private fun numIslands(grid: Array<CharArray>): Int {
    val nextPoints = ArrayDeque<Point>()
    val rowSize = grid.size
    val colSize = grid[0].size
    var res = 0
    for (i in 0 until rowSize) {
        for (j in 0 until colSize) {
            // initial island
            if (grid[i][j] == '1') {
                nextPoints.add(Point(i, j))
                grid[i][j] = '0'
                res++
            }
            // adjacent islands
            while (nextPoints.isNotEmpty()) {
                val currentPoint = nextPoints.removeFirst()
                currentPoint.doLeft(grid, colSize, nextPoints)
                currentPoint.doRight(grid, colSize, nextPoints)
                currentPoint.doTop(grid, rowSize, nextPoints)
                currentPoint.doBottom(grid, rowSize, nextPoints)
            }
        }
    }
    return res
}

private fun numIslandsRecursive(grid: Array<CharArray>): Int {
    var islands = 0
    val m = grid.size
    val n = grid[0].size
    for (i in 0 until m) {
        for (j in 0 until n) {
            if (grid[i][j] == '1') {
                islands++
                markNeighbours(grid, i, j, m, n)
            }
        }
    }
    return islands
}

private fun markNeighbours(grid: Array<CharArray>, i: Int, j: Int, m: Int, n: Int) {
    if (outOfBound(i, j, m, n) || grid[i][j] == '0')
        return
    grid[i][j] = '0'
    markNeighbours(grid, i, j - 1, m, n)
    markNeighbours(grid, i, j + 1, m, n)
    markNeighbours(grid, i - 1, j, m, n)
    markNeighbours(grid, i + 1, j, m, n)
}

private fun outOfBound(i: Int, j: Int, m: Int, n: Int): Boolean {
    return i < 0 || j < 0 || i > m - 1 || j > n - 1
}

fun main() {
    val input1 = arrayOf(
        charArrayOf('1', '1', '1', '1', '0'),
        charArrayOf('1', '1', '0', '1', '0'),
        charArrayOf('1', '1', '0', '0', '0'),
        charArrayOf('0', '0', '0', '0', '0')
    )
    val input2 = arrayOf(
        charArrayOf('1', '1', '0', '0', '0'),
        charArrayOf('1', '1', '0', '0', '0'),
        charArrayOf('0', '0', '1', '0', '0'),
        charArrayOf('0', '0', '0', '1', '1')
    )
    val result = numIslandsRecursive(input2)
    println(result)
}