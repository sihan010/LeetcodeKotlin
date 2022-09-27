package graph

// 133

private class Node(var `val`: Int) {
    var neighbors: ArrayList<Node?> = ArrayList<Node?>()
}

private fun cloneGraph(node: Node?): Node? {
    if(node==null)
        return null
    val clonedGraph = hashMapOf<Int, Node>()
    return clone(node, clonedGraph)
}

private fun clone(node: Node?, clonedGraph: HashMap<Int, Node>): Node? {
    if(clonedGraph.containsKey(node?.`val`))
        return clonedGraph[node?.`val`]
    val v = node?.`val`!!
    val clone = Node(v)
    clonedGraph[v] = clone
    for(neighbour in node.neighbors){
        clone.neighbors.add(clone(neighbour, clonedGraph))
    }
    return clone
}

fun main(){

}