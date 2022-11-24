private fun mergeSort(array: IntArray): IntArray {
    val size=array.size
    if (size == 1)
        return array

    val mid = (size-1) / 2
    val left = mergeSort(array.sliceArray(0..mid))
    val right = mergeSort(array.sliceArray(mid+1 until size))
    return merge(left, right)
}

private fun merge(left: IntArray, right: IntArray): IntArray {
    val res = mutableListOf<Int>()
    val lSize = left.size
    val rSize = right.size
    var i = 0
    var j = 0
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
        if (left[i] < right[j]) {
            res.add(left[i])
            i++
        } else {
            res.add(right[j])
            j++
        }
    }
    return res.toIntArray()
}

fun main() {
    val input = intArrayOf(6, 5,4,3,5,7,89,4,3,4,5,6,6)
    println(input.toList())
    val res = mergeSort(input)
    println(res.toList())
}