package arithmatic

// 7

private fun reverse(x: Int): Int {
    var result = 0L
    var input = x
    while (input != 0) {
        val r = input % 10
        result = result * 10 + r
        if (result < Int.MIN_VALUE || result > Int.MAX_VALUE)
            return 0
        input /= 10
    }
    return result.toInt()
}

fun main() {
    val res = reverse(123)
    println(res)
}