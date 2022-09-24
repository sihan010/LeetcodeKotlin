package array
import utils.printIntArray

// 238

fun productOfArrayWithoutSelf(nums: IntArray): IntArray {
    val output = MutableList(nums.size){1}
    var prefix=1
    var postfix =1
    val indices = nums.indices
    val reverseIndices = indices.reversed()
    for(i in indices){
        output[i] = prefix
        prefix*=nums[i]
    }

    for(i in reverseIndices){
        output[i]*=postfix
        postfix*=nums[i]
    }
    return output.toIntArray()
}

fun main() {
    val res = productOfArrayWithoutSelf(intArrayOf(1,2,3,4))
    res.printIntArray()
}