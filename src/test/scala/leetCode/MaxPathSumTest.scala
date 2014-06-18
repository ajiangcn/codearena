package scala.leetCode

import leetCode.MaxPathSum
import org.scalatest.FunSuite
import leetCode.MaxPathSum.TreeNode

class MaxPathSumTest extends FunSuite {

  test("test sample case") {
    val one = new TreeNode(1);
    val two = new TreeNode(2);
    val three = new TreeNode(3);

    one.setLeft(two)
    one.setRight(three)

    val result = new MaxPathSum().maxPathSum(one)
    assert(result == 6)
  }

  test("test case 1") {
    //val
  }

}
