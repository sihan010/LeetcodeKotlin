package tree

private fun levelOrder(root: TreeNode?): List<List<Int>> {
    val el = mutableListOf<MutableList<Int>>()
    if(root==null)
        return listOf()
    else{
        val q = ArrayDeque<TreeNode>()
        q.add(root)
        while(q.isNotEmpty()){
            val level = mutableListOf<Int>()
            for(i in 0 until q.size){
                level.add(q.first().`val`)
                val r = q.removeFirst()
                if(r.left!=null)
                    q.add(r.left!!)
                if(r.right!=null)
                    q.add(r.right!!)
            }
            el.add(level)
        }
    }
    return el
}

fun main(){
    val input = TreeNode(3)
    input.left = TreeNode(9)
    input.right = TreeNode(20)
    input.right?.left = TreeNode(15)
    input.right?.right = TreeNode(7)
    input.left?.left = TreeNode(14)
    input.left?.right = TreeNode(8)
    val res = levelOrder(input)
    println(res)
}