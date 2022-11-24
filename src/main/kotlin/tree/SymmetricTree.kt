package tree

// https://leetcode.com/problems/symmetric-tree/
// 101

private fun isSymmetric(root: TreeNode?): Boolean {
    if (root == null)
        return true
    return symm(root.left, root.right)
}

private fun symm(left: TreeNode?, right: TreeNode?): Boolean {
    // one of the nodes is null
    if ((left == null) xor (right == null))
        return false

    // both are null
    if ((left == null) && (right == null))
        return true

    // none are null
    // if values are not same return false
    // else check symmetry
    return if ((left?.`val` != right?.`val`))
        false
    else symm(left?.left, right?.right) && symm(left?.right, right?.left)
}

fun main() {

}