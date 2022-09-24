package array

// 1

fun twoSum(nums: IntArray, target: Int): IntArray {
    val hashMap = HashMap<Int, Int>()
    for (i in nums.indices) {
        val diff = target - nums[i]
        if (hashMap.containsKey(diff))
            return intArrayOf(hashMap.getValue(diff), i)
        hashMap[nums[i]] = i
    }
    return intArrayOf()
}

fun main() {
    val res = twoSum(intArrayOf(2, 7, 11, 15), 17)
    println(res.joinToString(",") { it.toString() })
}