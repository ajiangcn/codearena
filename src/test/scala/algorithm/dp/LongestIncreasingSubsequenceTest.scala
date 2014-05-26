package algorithm.dp

import org.scalatest.FunSuite

class LongestIncreasingSubsequenceTest extends FunSuite {

  test("Test simple case.") {
    val input = Array(10,22,9,33,21,50,41,60,80)
    val result = new LongestIncreasingSubsequence().lis(input)
   assert(result === 6)
  }
}
