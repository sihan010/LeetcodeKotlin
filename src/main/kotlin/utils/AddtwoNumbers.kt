package utils

private class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

private fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
    var num1 = 0L
    var num2 = 0L
    var multiplier = 1L

    var head = l1
    while (head!=null){
        num1+=head.`val`*multiplier
        multiplier*=10
        head = head.next
    }

    multiplier = 1
    head = l2
    while (head!=null){
        num2+=head.`val`*multiplier
        println(num2)
        multiplier*=10
        head = head.next
    }

    var sum = num1 + num2
    println("$num1 $num2 $sum")
    if(sum==0L)
        return ListNode(0)

    var resNode:ListNode? = null
    var currentNode:ListNode? = null
    while (sum>0){
        val r = (sum % 10).toInt()
        sum/=10
        if(resNode==null){
            resNode = ListNode(r)
            currentNode = resNode
        }
        else{
            val newNode = ListNode(r)
            currentNode?.next = newNode
            currentNode = newNode
        }
    }
    return resNode
}

private fun addTwoNumbers2(l1: ListNode?, l2: ListNode?): ListNode?{
    var node1 = l1
    var node2 = l2
    var first:ListNode? = null
    var current :ListNode? = null
    var rem = 0
    while (node1!=null || node2!=null){
        val num1 = if(node1!=null){
            val v = node1.`val`
            node1 = node1.next
            v
        } else 0
        val num2 = if(node2!=null){
            val v = node2.`val`
            node2 = node2.next
            v
        } else 0

        val sum = rem + num1 + num2

        val r = if(sum<10) sum else sum%10
        rem = sum/10
        if(first==null){
            val v = ListNode(r)
            first = v
            current = v
        }
        else{
            val v = ListNode(r)
            current?.next = v
            current = v
        }
    }
    if(rem>0){
        val v = ListNode(rem)
        current?.next = v
    }
    return first
}

private fun makeList(nums:IntArray):ListNode{
    val first = ListNode(nums[0])
    var current = first
    for(i in 1 until nums.size){
        val newNode = ListNode(nums[i])
        current.next = newNode
        current = newNode
    }
    return first
}

fun main(){
    val input1 = intArrayOf(9)
    val input2 = intArrayOf(1,9,9,9,9,9,9,9,9,9)


    var res:ListNode? = addTwoNumbers(makeList(input1), makeList(input2))
    while (res!=null){
        print("${res.`val`} ")
        res= res.next
    }

}