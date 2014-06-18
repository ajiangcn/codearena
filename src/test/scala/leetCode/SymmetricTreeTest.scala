package leetCode

import org.scalatest.FunSuite
import leetCode.SymmetricTree.{TreeNode=>TreeNode}

class SymmetricTreeTest extends FunSuite {

  test("test symmetric tree") {
    val root = new TreeNode(1,
      new TreeNode(2, new TreeNode(3),new TreeNode(4)),
      new TreeNode(2, new TreeNode(4), new TreeNode(3)))

    val solution = new SymmetricTree
    assert(solution.isSymmetric(root) === true)
  }

  test("test unsymmetric tree") {
    val root = new TreeNode(1,
      new TreeNode(2, null, new TreeNode(3)),
      new TreeNode(2, null, new TreeNode(3)))

    val solution = new SymmetricTree
    assert(solution.isSymmetric(root) === false)
  }

  test("test unsymmetric tree II") {
    val root = new TreeNode(1,
      new TreeNode(2, new TreeNode(3), null),
      new TreeNode(3, new TreeNode(2), null))

    val solution = new SymmetricTree
    assert(solution.isSymmetric(root) === false)
  }

}
