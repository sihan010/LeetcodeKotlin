import java.util.Stack

private data class Node(
    val data: Int,
    var left: Node? = null,
    var right: Node? = null
)

private fun printLeftEdge(node: Node?) {
    if (node == null)
        return
    printLeftEdge(node.left)
    print("${node.data} ")
}

private fun printRightEdge(node: Node?) {
    if (node == null)
        return
    print("${node.data} ")
    printRightEdge(node.right)
}

private fun printTree(node:Node?){
    if(node==null)
        return
    // In Order
    printTree(node.left)
    print("${node.data} ")
    printTree(node.right)

    // Pre order
//    print("${node.data} ")
//    printTree(node.left)
//    printTree(node.right)

    // Post Order
//    printTree(node.left)
//    printTree(node.right)
//    print("${node.data} ")
}

private fun printTreeDS(node:Node?){
    val st = ArrayDeque<Node?>()
    st.add(node)
    while (st.isNotEmpty()){
        val current = st.removeFirst()
        if(current?.left!==null) st.add(current.left)
        if(current?.right!==null) st.add(current.right)
        print("${current?.data} ")
    }
}

fun main() {
//                1
//            2       3
//           4  5    6  7
    val root = Node(1)
    root.left = Node(2)
    root.right = Node(3)
    root.left?.left = Node(4)
    root.left?.right = Node(5)
    root.right?.left = Node(6)
    root.right?.right = Node(7)
    printLeftEdge(root)
    printRightEdge(root.right)
//    printTree(root)
//    printTreeDS(root)

}