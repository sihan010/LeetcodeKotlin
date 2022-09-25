package string

// 345

private fun reverseVowels(s: String): String {
    val chars = s.toCharArray()
    var left = 0
    var right = chars.size-1
    while (left<right){
        val leftIsVowel = isVowel(chars[left])
        val rightIsVowel = isVowel(chars[right])
        if(leftIsVowel && rightIsVowel){
            swapChars(chars, left, right)
            left++
            right--
        }
        if(!leftIsVowel)
            left++
        if(!rightIsVowel)
            right--
    }
    return String(chars)
}

private fun swapChars(chars: CharArray, left: Int, right: Int) {
    val temp = chars[left]
    chars[left] = chars[right]
    chars[right] = temp
}

private fun isVowel(c: Char): Boolean {
    val l = c.lowercaseChar()
    return l =='a' || l =='e' || l =='i' || l =='o' || l =='u'
}

fun main(){
    val res = reverseVowels("hello")
    println(res)
}