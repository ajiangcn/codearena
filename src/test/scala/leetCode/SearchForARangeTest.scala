package scala.leetCode

import org.scalatest.FunSuite
import leetCode.SearchForARange

class SearchForARangeTest extends FunSuite {

  test("5,7,7,8,8,10") {

    val input = Array(5,7,7,8,8,10)
    val result1 = new SearchForARange().searchRange(input, 8)
    val expectedResult1 = Array(3,4)
    assert(result == expectedResult1)

  }

}
