package array

import kotlin.math.abs

// 442
// https://leetcode.com/problems/find-all-duplicates-in-an-array/

private fun findDuplicates(nums: IntArray): List<Int> {
    val result = mutableListOf<Int>()
    val indices = nums.indices
    for (i in indices) {
        val index = abs(nums[i]) - 1
        if (nums[index] < 0)
            result.add(index + 1)
        else nums[index] = -nums[index]
    }
    return result.toList()
}

fun main() {
    val res = findDuplicates(intArrayOf(4, 3, 2, 7, 8, 2, 3, 1))
    println(res)
}