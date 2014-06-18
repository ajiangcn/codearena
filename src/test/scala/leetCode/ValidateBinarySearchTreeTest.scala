package leetCode

import org.scalatest.FunSuite

import ValidateBinarySearchTree.TreeNode

/**
 * Created by youjiang on 3/18/14.
 */
class ValidateBinarySearchTreeTest extends FunSuite {

  test("Test validating a true binary search tree.") {
    val tree = new TreeNode(3, new TreeNode(2, new TreeNode(1, null, null), null), new TreeNode(4))

    val solution = new ValidateBinarySearchTree
    val result = solution.isValidBST(tree)
    assert(result === true)
  }

  test("Test validating a false binary search tree.") {
    val tree = new TreeNode(2, new TreeNode(3, new TreeNode(1, null, null), null), new TreeNode(4))

    val solution = new ValidateBinarySearchTree
    val result = solution.isValidBST(tree)
    assert(result === false)
  }

}
