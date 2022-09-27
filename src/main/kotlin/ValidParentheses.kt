import java.util.Stack

// 20

private fun isValid(s: String): Boolean {
    val st = Stack<Char>()
    val l = s.length
    for (i in 0 until l) {
        if (s[i] == '(' || s[i] == '{' || s[i] == '[') {
            st.push(s[i])
            continue
        }

        if (st.empty())
            return false

        when (s[i]) {
            ')' -> if (st.pop() != '(') return false
            '}' -> if (st.pop() != '{') return false
            ']' -> if (st.pop() != '[') return false
        }
    }
    return st.empty()
}

fun main() {
    val res = isValid("()[]{}{{")
    println(res)
}