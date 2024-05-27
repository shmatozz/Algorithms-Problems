package leetcode.medium

import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

data class NodeInfo(var min: Int, var max: Int, var diff: Int)

fun maxAncestorDiff(root: TreeNode?): Int {
    return getInfo(root).diff
}

fun getInfo(node: TreeNode?) : NodeInfo {
    if (node == null) {
        return NodeInfo(Int.MAX_VALUE, Int.MIN_VALUE, -1)
    }

    if (node.right == null && node.left == null) {
        return NodeInfo(node.`val`, node.`val`, 0)
    }

    val infoLeft = getInfo(node.left)
    val infoRight = getInfo(node.right)

    val diffLeft = if (infoLeft.diff != -1) {
        max(abs(node.`val` - infoLeft.min), max(abs(node.`val` - infoLeft.max), infoLeft.diff))
    } else {
        -1
    }

    val diffRight = if (infoRight.diff != -1) {
        max(abs(node.`val` - infoRight.min), max(abs(node.`val` - infoRight.max), infoRight.diff))
    } else {
        -1
    }

    return NodeInfo(
        min(node.`val`, min(infoLeft.min, infoRight.min)),
        max(node.`val`, max(infoLeft.max, infoRight.max)),
        max(diffLeft, diffRight)
    )
}

fun main () {
    val root = TreeNode(8)
    root.left = TreeNode(3)
    root.left!!.left = TreeNode(1)
    root.left!!.right = TreeNode(6)
    root.left!!.right!!.left = TreeNode(4)
    root.left!!.right!!.right = TreeNode(7)
    root.right = TreeNode(10)
    root.right!!.right = TreeNode(14)
    root.right!!.right!!.left = TreeNode(13)

//    val root = TreeNode(1)
//    root.right = TreeNode(2)
//    root.right!!.right = TreeNode(0)
//    root.right!!.right!!.left = TreeNode(3)

    println(maxAncestorDiff(root))
}