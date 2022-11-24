package binary

import utils.printIntArray

// https://leetcode.com/problems/counting-bits/

private fun countBits(n: Int): IntArray {
    val dp = Array(n+1){0}
    dp[0] = 0
    var offset = 1
    for(i in 1..n){
        if(i == 2 * offset)
            offset = i
        dp[i] = 1 + dp[i-offset]
    }
    return dp.toIntArray()
}

fun main(){
    val res = countBits(5)
    res.printIntArray()
}

