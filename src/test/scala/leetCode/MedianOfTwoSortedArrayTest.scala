package leetCode

import org.scalatest.FunSuite

/**
 * Created by youjiang on 3/17/14.
 */
class MedianOfTwoSortedArrayTest extends FunSuite{

  test("test simple case") {
    val A = Array(1,3,5)
    val B = Array(2,4,6)

    val solution = new MedianOfTwoSortedArray
    val result = solution.findMedianSortedArrays(A, B)

    assert(result === 3.5)
  }

  test("test simple case 2") {
    val A = Array(1,3,5)
    val B = Array(2,4)

    val solution = new MedianOfTwoSortedArray
    val result = solution.findMedianSortedArrays(A, B)

    assert(result === 3d)
  }
}
