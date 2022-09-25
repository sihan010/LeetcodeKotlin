package string

import java.math.BigInteger

// 8

private fun myAtoi(s: String): Int {
    val trimmed = s.trimStart()
    if (trimmed.isEmpty())
        return 0
    var res = BigInteger.valueOf(0L)
    var sign = 1
    var start = 0
    if (trimmed[0] == '-') {
        sign = -1
        start = 1
    } else if (trimmed[0] == '+') {
        sign = 1
        start = 1
    }
    val indices = start until trimmed.length

    for (i in indices) {
        if (!trimmed[i].isDigit())
            break
        res = res * BigInteger.TEN + (trimmed[i].toInt() - 48).toBigInteger()
    }
    res*=sign.toBigInteger()
    return if (res < Int.MIN_VALUE.toBigInteger())
        Int.MIN_VALUE
    else if (res > Int.MAX_VALUE.toBigInteger())
        Int.MAX_VALUE
    else res.toInt()
}

fun main() {
    val res = myAtoi("-92233")
    println(res)
}