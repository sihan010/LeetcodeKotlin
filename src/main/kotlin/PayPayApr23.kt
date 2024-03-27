/**
Consider a rectangular h × w board with all cells initially white. You are to process several queries of the following types:

"x a b" - color the white cell (a, b) (0-based coordinates, the first one is a row index, and the second one is a column index) black;
"> a b" - find the leftmost white cell to the right of the white cell (a, b);
"< a b" - find the rightmost white cell to the left of the white cell (a, b);
"v a b" - the same, but the search should be done downwards;
"^ a b" - the same, but the search should be done upwards;
For each query, except the ones of the first type, find the answer.

For h = 3, w = 5, and
queries = ["v 1 2", "x 2 2", "v 1 2", "> 2 1", "x 2 3", "> 2 1", "< 2 0"],
the output should be
solution(h, w, queries) = [[2, 2], [-1, -1], [2, 3], [2, 4], [-1, -1]]
 */
private fun solution1(h: Int, w: Int, queries: MutableList<String>): MutableList<MutableList<Int>> {
    val data = Array(h) { BooleanArray(w) { false } } // data field with all false
    val res = mutableListOf<MutableList<Int>>() // hold result list
    queries.forEach { query ->
        val splited = query.split(" ")
        val action = splited[0]
        val row = splited[1].toInt()
        val col = splited[2].toInt()
        when (action) {
            "x" -> {
                // mark black
                data[row][col] = true
            }
            ">" -> {
                var f = false // did we find white ?
                for (i in col + 1 until w) {
                    if (!data[row][i]) {
                        // found white, add to res and break
                        res.add(mutableListOf(row, i))
                        f = true
                        break
                    }
                }
                if (!f) res.add(mutableListOf(-1, -1)) // did not find white, add [-1,-1]
            }
            "<" -> {
                var f = false // did we find white ?
                for (i in col - 1 downTo 0) {
                    if (!data[row][i]) {
                        // found white, add to res and break
                        res.add(mutableListOf(row, i))
                        f = true
                        break
                    }
                }
                if (!f) res.add(mutableListOf(-1, -1)) // did not find white, add [-1,-1]
            }
            "^" -> {
                var f = false // did we find white ?
                for (i in row - 1 downTo 0) {
                    if (!data[i][col]) {
                        // found white, add to res and break
                        res.add(mutableListOf(i, col))
                        f = true
                        break
                    }
                }
                if (!f) res.add(mutableListOf(-1, -1)) // did not find white, add [-1,-1]
            }
            "v" -> {
                var f = false // did we find white ?
                for (i in row + 1 until h) {
                    if (!data[i][col]) {
                        // found white, add to res and break
                        res.add(mutableListOf(i, col))
                        f = true
                        break
                    }
                }
                if (!f) res.add(mutableListOf(-1, -1)) // did not find white, add [-1,-1]
            }
        }
    }
    return res
}

/**
An array is called palindromic if it remains the same after reversing the order of its elements.

You have an array of strings arr. For each i, arr[i] consists of at least two characters. For each pair of consecutive elements arr[i] and arr[i + 1], you can:

Move the rightmost character of arr[i] to the leftmost position in arr[i + 1]. For instance, "abc" and "def" will become "ab" and "cdef". This operation can be applied only once to any pair of consecutive elements.
Move the leftmost character of arr[i + 1] to the rightmost position in arr[i]. For instance, "abc" and "def" will become "abcd" and "ef". Again, this operation can be applied only once to any pair of consecutive elements.
Do nothing to the pair of consecutive elements.
Is it possible to obtain a palindromic array from arr by performing these operations?

Example

For arr = ["aa", "bab", "cde", "aba", "ab"], the output should be
solution(arr) = true.

Apply the second operation to "aa" and "bab".
Apply the first operation to "aba" and "ab".
This gives us the following array: ["aab", "ab", "cde", "ab", "aab"], which is palindromic.
For arr = ["palindrome"], the output should be
solution(arr) = true.

The given array is already palindromic, so no operations are needed.

For arr = ["aaaaaa", "aa"], the output should be
solution(arr) = false.

If moving two characters between two consecutive array elements was allowed, the array could have been made palindromic, but this is impossible given the actual rules.
 */
class PalindromeNode(var `val`: Array<String>) {
    var left: PalindromeNode? = null
    var right: PalindromeNode? = null
    var neutral: PalindromeNode? = null
}

private fun solution2(arr: Array<String>): Boolean {
    val n = arr.size
    if (n == 1)
        return true

    val root = PalindromeNode(arr)
    generatePalindromeCandidates(root, 0, n)
    // traversePalindromeCandidates(root)
    return getIfPalindromePossible(root)
}

fun getIfPalindromePossible(root: PalindromeNode): Boolean {
    val q = ArrayDeque<PalindromeNode>()
    q.add(root)
    while (q.isNotEmpty()) {
        val v = q.removeFirst()
        if (isPalindrome(v.`val`))
            return true

        if (v.left != null)
            q.add(v.left!!)
        if (v.right != null)
            q.add(v.right!!)
        if (v.neutral != null)
            q.add(v.neutral!!)
    }
    return false
}

private fun generatePalindromeCandidates(root: PalindromeNode, index: Int, n: Int) {
    if (index > n - 2)
        return
    // first operation
    val n1 = root.`val`.clone()
    n1[index] = root.`val`[index].dropLast(1)
    n1[index + 1] = root.`val`[index].last() + root.`val`[index + 1]

    // second operation
    val n2 = root.`val`.clone()
    n2[index] = root.`val`[index] + root.`val`[index + 1].first()
    n2[index + 1] = root.`val`[index + 1].drop(1)

    // neutral operation
    val n3 = root.`val`.clone()

    root.left = PalindromeNode(n1)
    root.right = PalindromeNode(n2)
    root.neutral = PalindromeNode(n3)

    generatePalindromeCandidates(root.left!!, index + 1, n)
    generatePalindromeCandidates(root.right!!, index + 1, n)
    generatePalindromeCandidates(root.neutral!!, index + 1, n)
}

private fun traversePalindromeCandidates(root: PalindromeNode) {
    val q = ArrayDeque<PalindromeNode>()
    q.add(root)
    while (q.isNotEmpty()) {
        val v = q.removeFirst()
        println(v.`val`.joinToString(", ") + " ----> " + isPalindrome(v.`val`))

        if (v.left != null)
            q.add(v.left!!)
        if (v.right != null)
            q.add(v.right!!)
        if (v.neutral != null)
            q.add(v.neutral!!)
    }
}

private fun isPalindrome(arr: Array<String>): Boolean {
    val n = arr.size
    for (i in 0 until n / 2) {
        if (arr[i] != arr[n - i - 1]) {
            return false
        }
    }
    return true
}

fun main() {
//    val res = solution1(3,5, mutableListOf("v 1 2", "x 2 2", "v 1 2", "> 2 1", "x 2 3", "> 2 1", "< 2 0"))
//    println(res)

//    val res = solution2(arrayOf("aaaaaaa", "aa")) //false
//    val res = solution2(arrayOf("palindrome")) //true
    val res = solution2(arrayOf("aa", "bab", "cde", "aba", "ab")) //true
    println(res)
}