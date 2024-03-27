package array

fun removeDuplicates(nums: IntArray): Int {
    val n = nums.size
    if (n == 1)
        return 1
    var (L, R) = listOf(0, 1)
    while (R < n) {
        if (nums[L] == nums[R]) {
            R++
        } else {
            // swap R with L+1
            nums[L + 1] = nums[R]
            //L++, R++
            L++
            R++
        }
    }
    return L + 1
}

fun main() {
    val res = removeDuplicates(intArrayOf(0, 0, 0,0,0,1, 1, 1, 2, 2, 3, 3, 4))
    println(res)
}