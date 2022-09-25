package string

// 1859

private fun sortSentence(s: String): String {
    val words = s.split(" ")
    val res = MutableList(words.size) { "" }
    for (word in words) {
        res[word.last().digitToInt() - 1] = word.substring(0, word.lastIndex)
    }
    return res.joinToString(" ")
}

fun main() {
    val res = sortSentence("is2 sentence4 This1 a3")
    println(res)
}