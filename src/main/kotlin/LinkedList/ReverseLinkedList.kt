package LinkedList

import java.util.Stack

class ListNode(var `val`: Char) {
    var next: ListNode? = null
}

private fun printLinkedList(head: ListNode?) {
    var curr: ListNode? = head
    while (curr != null) {
        print("${curr.`val`} ")
        curr = curr.next
    }
    println()
}

private fun reverseList(head: ListNode?): ListNode? {
    var curr: ListNode? = head ?: return null
    var prev: ListNode? = null
    while (curr != null) {
        val temp = ListNode(curr.`val`)
        temp.next = prev
        prev = temp
        curr = curr.next
    }
    return prev
}

private fun reverseListStack(head: ListNode?): ListNode? {
    var curr: ListNode? = head ?: return null
    val st = Stack<Char>()
    while (curr != null) {
        st.push(curr.`val`)
        curr = curr.next
    }
    val res = ListNode(st.pop())
    var it: ListNode? = res
    while (st.isNotEmpty()) {
        it?.next = ListNode(st.pop())
        it = it?.next
    }
    return res
}

var res=ListNode('!')
var prev=res
private fun reverseListRecursive(head:ListNode?):ListNode?{
    if(head==null)
        return null
    reverseListRecursive(head.next)
    val temp=ListNode(head.`val`)
    prev.next=temp
    prev=temp
    return res.next
}

fun main() {
    val head = ListNode('A')
    var curr: ListNode? = head
    for (i in 2..26) {
        curr?.next = ListNode((i + 64).toChar())
        curr = curr?.next
    }
    println("Before")
    printLinkedList(head)

    println("Reversed with Pointer")
    val reversed = reverseList(head)
    printLinkedList(reversed)

    println("Reversed with Stack")
    val reversedStack = reverseListStack(head)
    printLinkedList(reversedStack)

    println("Reversed with Recursion")
    val reversedRecursive = reverseListRecursive(head)
    printLinkedList(reversedRecursive)
}
