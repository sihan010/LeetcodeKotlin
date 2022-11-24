package array
import kotlin.math.max

// Kadane’s Algorithm
// LeetCode: 53
// https://www.geeksforgeeks.org/largest-sum-contiguous-subarray/

private fun maxSubArray(nums: IntArray): Int {
    var max = nums[0]
    var current = 0
    for(i in nums.indices){

        if(current<0){
            current=0
        }
        current+=nums[i]
        max= max(current,max)
    }
    return max
}

fun main() {
    val res = maxSubArray(intArrayOf(-2,-5))
    println(res)
}