package array

fun moveZeroes(nums: IntArray): Unit {
    val n = nums.size
    if (n > 1) {
        var (L, R) = listOf(0, 1)
        while (R < n) {
            if (nums[L] != 0) {
                L++
                R++
            } else if (nums[R] == 0) {
                R++
            } else {
                // swap
                val temp = nums[R]
                nums[R] = nums[L]
                nums[L] = temp
            }
        }
    }
    println(nums.toList())
}

fun main() {
    moveZeroes(intArrayOf(0, 1, 0, 3, 12))
}