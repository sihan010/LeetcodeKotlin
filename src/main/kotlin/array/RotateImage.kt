package array

import utils.print2dArray

private fun rotate(matrix: Array<IntArray>): Unit {
    val n = matrix.size

    // Transpose
    for (i in 0 until n) {
        for (j in i until n) {
            swap(matrix, i, j, j, i)
        }
    }

    // Reverse
    for (i in 0 until n) {
        var left = 0
        var right = n - 1
        while (left < right) {
            swap(matrix, i, left, i, right)
            left++
            right--
        }
    }
}

private fun swap(matrix: Array<IntArray>, i: Int, j: Int, k: Int, l: Int) {
    val temp = matrix[i][j]
    matrix[i][j] = matrix[k][l]
    matrix[k][l] = temp
}

fun main() {
    val input1 = arrayOf(
        intArrayOf(1, 2, 3),
        intArrayOf(4, 5, 6),
        intArrayOf(7, 8, 9)
    )
    rotate(input1)
    println(input1.print2dArray())
}