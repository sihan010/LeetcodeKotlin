// 62
// https://leetcode.com/problems/unique-paths/
// Dynamic Programming

fun uniquePaths(m: Int, n: Int): Int {
    val dp = Array(m) { IntArray(n) }
    for (i in 0 until m) {
        for (j in 0 until n) {
            if (i == 0 || j == 0)
                dp[i][j] = 1
            else
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
        }
    }
    return dp[m - 1][n - 1]
}

fun main() {
    val res = uniquePaths(3, 7)
    println(res)
}