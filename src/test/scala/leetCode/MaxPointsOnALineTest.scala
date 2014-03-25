package leetCode

import org.scalatest.FunSuite

/**
 * Created by youjiang on 3/17/14.
 */
class MaxPointsOnALineTest extends FunSuite {

  test("test simple cases") {
    val solution = new MaxPointsOnALine;
    val result = solution.maxPoints(Array(new MaxPointsOnALine.Point(1,3),
      new MaxPointsOnALine.Point(2,4),
      new MaxPointsOnALine.Point(3,6)))
    assert(result === 3)
  }

}
