package binary

private fun missingNumber(nums: IntArray): Int {
    val n = nums.size
    val rangeSum = (n * (1 + n))/2
    val arraySum = nums.sum()
    return rangeSum-arraySum
}

fun main(){
    val res = missingNumber(intArrayOf(9,6,4,2,3,5,7,0,1))
    println(res)
}