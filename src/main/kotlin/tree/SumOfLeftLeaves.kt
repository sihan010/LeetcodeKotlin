package tree

// 404

private class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

private fun sumOfLeftLeaves(root: TreeNode?): Int {
    var sum = 0
    if(root==null) return 0
    if(root.left!=null){
        sum += if(isLeaf(root.left!!)){
            root.left!!.`val`
        } else sumOfLeftLeaves(root.left)
    }
    sum+=sumOfLeftLeaves(root.right)

    return sum
}

private fun isLeaf(node: TreeNode): Boolean {
    return node.left!=null && node.right!=null
}

fun main() {

}