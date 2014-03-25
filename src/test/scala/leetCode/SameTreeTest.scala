package leetCode

import org.scalatest.FunSuite

/**
 * Created by youjiang on 3/17/14.
 */
class SameTreeTest extends FunSuite{

  test("test the same tree") {
    val node1 = new SameTree.TreeNode(1, new SameTree.TreeNode(2), new SameTree.TreeNode(3))
    val node2 = new SameTree.TreeNode(1, new SameTree.TreeNode(2), new SameTree.TreeNode(3))

    val solution = new SameTree
    assert(solution.isSameTree(node1, node2) === true)
  }

  test("test different tree.") {
    val node1 = new SameTree.TreeNode(1, new SameTree.TreeNode(2), new SameTree.TreeNode(3))
    val node2 = new SameTree.TreeNode(1, new SameTree.TreeNode(2), new SameTree.TreeNode(5))

    val solution = new SameTree
    assert(solution.isSameTree(node1, node2) === false)
  }
}
