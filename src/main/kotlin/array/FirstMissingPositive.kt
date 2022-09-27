package array

import kotlin.math.abs

// 41

private fun firstMissingPositive(nums: IntArray): Int {
    val n = nums.size
    var containsOne = false
    for (i in 0 until n) {
        if (nums[i] == 1)
            containsOne = true
        else if (nums[i] <= 0 || nums[i] > n)
            nums[i] = 1
    }

    if(!containsOne) return 1

    for (i in 0 until n) {
        val index = abs(nums[i]) - 1
        if(nums[index]>0)
            nums[index] = -1 * nums[index]
    }

    for (i in 0 until n) {
        if (nums[i] > 0)
            return i + 1
    }
    return n + 1
}

fun main() {
    val res = firstMissingPositive(intArrayOf(1, 2, 0))
    println(res)
}