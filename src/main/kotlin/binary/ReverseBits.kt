package binary


private fun reverseBits(n:Int):Int {
    return java.lang.Long.parseLong(
        Integer.toBinaryString(n).padStart(32, '0').reversed(),
        2
    ).toInt()
}

fun main () {
    val res = reverseBits(-3)
    println(res)
}