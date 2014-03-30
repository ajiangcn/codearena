package leetCode

import org.scalatest.FunSuite
import leetCode.BSTLevelOrderTraversal.TreeNode
import java.util.ArrayList

class BSTLevelOrderTraversalTest extends FunSuite {

  test("test sample case") {
    val root = new TreeNode(3,
      new TreeNode(9),
      new TreeNode(20, new TreeNode(15), new TreeNode(7)))

    val solution = new BSTLevelOrderTraversal
    val result = solution.levelOrder(root)

    val level1 = new ArrayList[Integer]()
    level1.add(3)
    val level2 = new ArrayList[Integer]()
    level2.add(9);
    level2.add(20)
    val level3 = new ArrayList[Integer]()
    level3.add(15)
    level3.add(7)

    assert(result.get(0).equals(level1))
    assert(result.get(1).equals(level2))
    assert(result.get(2).equals(level3))
  }

}
