import java.util.Stack
import kotlin.math.min

// 155

private class MinStack() {
    val s = Stack<Int>()
    val t = Stack<Int>()

    fun push(`val`: Int) {
        s.push(`val`)
        val min = if(t.isEmpty()) `val` else min(`val`, s.peek())
        t.push(min)
    }

    fun pop() {
        s.pop()
        t.pop()
    }

    fun top(): Int {
        return s.peek()
    }

    fun getMin(): Int {
        return t.peek()
    }

}