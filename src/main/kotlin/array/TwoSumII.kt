package array

import utils.printIntArray

// 167
private fun twoSum(numbers: IntArray, target: Int): IntArray {
    var left = 0
    var right = numbers.size - 1
    while (left < right) {
        val sum = numbers[left] + numbers[right]
        if (sum == target)
            return intArrayOf(left + 1, right + 1)
        else if (sum < target) {
            left++
        } else if (sum > target) {
            right--
        }
    }
    return intArrayOf()
}

fun main() {
    val res = twoSum(intArrayOf(2, 7, 11, 15), 9)
    res.printIntArray()
}