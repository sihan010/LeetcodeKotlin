// 53

import kotlin.math.max

fun maxSubArray(nums: IntArray): Int {
    var max = nums[0]
    var current = 0
    for(i in nums.indices){
        if(current<0)
            current = 0
        current+=nums[i]
        max = max(max, current)
    }
    return max
}

fun main() {
    val res = maxSubArray(intArrayOf(-2,1,-3,4,-1,2,1,-5,4))
    println(res)
}