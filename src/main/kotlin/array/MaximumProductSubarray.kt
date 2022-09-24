package array
import kotlin.math.max

// 152

fun maxProduct(nums: IntArray): Int {
    var result = nums.maxOrNull() ?:1
    var currentMin=1
    var currentMax=1

    for(i in nums.indices){
        if(nums[i]==0){
            currentMin=1
            currentMax=1
            continue
        }
        val prevMax = currentMax*nums[i]
        currentMax = maxOf(prevMax, currentMin*nums[i], nums[i])
        currentMin = minOf(prevMax, currentMin*nums[i], nums[i])
        result = max(currentMax, result)
    }
    return result
}

fun main() {
    val res = maxProduct(intArrayOf(2,3,-2,4))
    println(res)
}