package topcoder.SRM613

import org.scalatest.FunSuite

class TaroFriendsTest extends FunSuite {

  def testutil(coordinates: Array[Int], X: Int, expected: Int) {
    val solution = new TaroFriends
    val result = solution.getNumber(coordinates, X)
    assert(result === expected)
  }

  test("test") {
    testutil(Array(-3,0,1), 3, 3)
    testutil(Array(4,7,-7), 5, 4)
    testutil(Array(-100000000, 100000000), 100000000, 0)
    testutil(Array(3,7,4,6,-10,7,10,9,-5), 7,7)
    testutil(Array(-4,0,4,0), 4, 4)
    testutil(Array(7), 0, 0)
  }

}
