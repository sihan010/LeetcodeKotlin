// 217

fun containsDuplicate(nums: IntArray): Boolean {
    val visited = mutableSetOf<Int>()
    for (i in nums.indices) {
        if(visited.contains(nums[i]))
            return true
        visited.add(nums[i])
    }
    return false
}

fun main() {
    val res = containsDuplicate(intArrayOf(2, 7, 11, 15))
    println(res)
}