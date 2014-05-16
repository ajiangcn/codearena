package scala.leetCode

import org.scalatest.FunSuite
import leetCode.PathSum.TreeNode
import leetCode.PathSum

import scala.collection.JavaConverters._

class PathSumTest extends FunSuite {

  test("test sample tree") {
    val five = new TreeNode(5)
    val four = new TreeNode(4)
    val eight = new TreeNode(8)
    val eleven = new TreeNode(11)
    val thirteen = new TreeNode(13)
    val four2 = new TreeNode(4)
    val seven = new TreeNode(7)
    val two = new TreeNode(2)
    val one = new TreeNode(1)

    five.setLeft(four)
    five.setRight(eight)
    four.setLeft(eleven)
    eight.setLeft(thirteen)
    eight.setRight(four2)
    eleven.setLeft(seven)
    eleven.setRight(two)
    four2.setRight(one)

    val result = new PathSum().hasPathSum(five, 22)
    assert(result === true)

  }

  test("test path sum 2") {
    val five = new TreeNode(5)
    val four = new TreeNode(4)
    val eight = new TreeNode(8)
    val eleven = new TreeNode(11)
    val thirteen = new TreeNode(13)
    val four2 = new TreeNode(4)
    val seven = new TreeNode(7)
    val two = new TreeNode(2)
    val five2 = new TreeNode(5)
    val one = new TreeNode(1)

    five.setLeft(four)
    five.setRight(eight)
    four.setLeft(eleven)
    eight.setLeft(thirteen)
    eight.setRight(four2)
    eleven.setLeft(seven)
    eleven.setRight(two)
    four2.setLeft(five2)
    four2.setRight(one)

    val pathSum2Result = new PathSum().pathSum(five, 22)

    for (result <- pathSum2Result.asScala) {
      println(result.asScala.mkString(","))

    }
  }

}
