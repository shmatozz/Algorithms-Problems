package leetcode.medium

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun amountOfTime(root: TreeNode?, start: Int): Int {
    if (root == null) {
        return 0
    }

    val graph = mutableMapOf<Int, MutableList<Int>>()

    buildGraph(graph, root)

    val queue = ArrayDeque<Int>()
    val visited = mutableMapOf<Int, Int>()
    visited[start] = 0
    queue.add(start)
    while (queue.isNotEmpty()) {
        val cur = queue.first()
        queue.removeFirst()
        for (i in graph[cur]!!) {
            if (visited.getOrDefault(i, -1) == -1) {
                queue.add(i)
                visited[i] = visited[cur]!! + 1
            }
        }
    }

    return visited.values.max()
}

fun buildGraph(graph: MutableMap<Int, MutableList<Int>>, node: TreeNode) {
    graph[node.`val`] = graph.getOrDefault(node.`val`, mutableListOf())

    if (node.left != null) {
        graph[node.`val`]!!.add(node.left!!.`val`)
        graph[node.left!!.`val`] = graph.getOrDefault(node.left!!.`val`, mutableListOf())
        graph[node.left!!.`val`]!!.add(node.`val`)
        buildGraph(graph, node.left!!)
    }

    if (node.right != null) {
        graph[node.`val`]!!.add(node.right!!.`val`)
        graph[node.right!!.`val`] = graph.getOrDefault(node.right!!.`val`, mutableListOf())
        graph[node.right!!.`val`]!!.add(node.`val`)
        buildGraph(graph, node.right!!)
    }
}

fun main() {
    val root = TreeNode(1)
    root.left = TreeNode(5)
    root.left!!.right = TreeNode(4)
    root.left!!.right!!.left = TreeNode(9)
    root.left!!.right!!.right = TreeNode(2)
    root.right = TreeNode(3)
    root.right!!.left = TreeNode(10)
    root.right!!.right = TreeNode(6)
    println(amountOfTime(root, 3))
}
