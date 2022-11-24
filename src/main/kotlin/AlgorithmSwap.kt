private fun getSwaps(array: IntArray): Int {
    val sortedWithSwaps = mergeSort(array)
    println(sortedWithSwaps)
    return 1
}

private fun mergeSort(array: IntArray): IntArray {
    val size = array.size
    if (size == 1)
        return array

    val mid = (size - 1) / 2
    val left = mergeSort(array.sliceArray(0..mid))
    val right = mergeSort(array.sliceArray(mid + 1 until size))

    return merge(left, right)
}

private fun merge(left: IntArray, right: IntArray): IntArray {
    var swaps = 0
    val res = mutableListOf<Int>()
    val lSize = left.size
    val rSize = right.size
    var i = 0
    var j = 0
    println("${left.toList()} ${right.toList()}")
    while (i < lSize || j < rSize) {
        if (i >= lSize) {
            res.add(right[j])
            j++
            continue
        }
        if (j >= rSize) {
            res.add(left[i])
            i++
            continue
        }
        if (left[i] <= right[j]) {
            res.add(left[i])
            i++
        } else {
            swaps++
            res.add(right[j])
            j++
        }
    }
    println(swaps)
    return res.toIntArray()
}

fun main() {
    val input = intArrayOf(5,2,6,1)
    val res = getSwaps(input)
    //println(res)
}