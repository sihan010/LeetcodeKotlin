package array
import utils.printIntArray

// 238

private fun productOfArrayWithoutSelf(nums: IntArray): IntArray {
    val prefix = MutableList(nums.size){0}
    val postfix = MutableList(nums.size){0}
    val result = MutableList(nums.size){0}
    prefix[0]= nums[0]
    for(i in 1 until nums.size){
        prefix[i] =  prefix[i-1] * nums[i]
    }

    postfix[nums.size-1] = nums[nums.size-1]
    for(i in nums.size-2 downTo 0){
        postfix[i] =  postfix[i+1]* nums[i]
    }

    for(i in nums.indices){
        val pre = if(i-1<0) 1 else prefix[i-1]
        val post = if(i+1>nums.size-1) 1 else postfix[i+1]
        result[i] = pre*post
    }

//    println(prefix)
//    println(postfix)
    return result.toIntArray()
}

fun main() {
    val res = productOfArrayWithoutSelf(intArrayOf(1,2,3,4))
    res.printIntArray()
}