package string

import java.util.*

// 415

private fun addStrings(num1: String, num2: String): String {
    val n1 = num1.toCharArray()
    val n2 = num2.toCharArray()
    var i = n1.size - 1
    var j = n2.size - 1
    var carry = 0
    var result = ""

    while (i >= 0 || j >= 0) {
        val first = if (i >= 0) n1[i] - '0' else 0
        val second = if (j >= 0) n2[j] - '0' else 0

        val sum = first + second + carry

        println("$first , $second = $sum")
        if (sum > 9) {
            carry = sum / 10
            result += (sum % 10).toString()
        } else {
            carry = 0
            result+=sum.toString()
        }
        i--
        j--
    }
    println(result)
    return if (carry == 0) result.reversed() else carry.toString() + result.reversed()
}

fun main() {
    val res = addStrings("66", "66")
    println(res)
}