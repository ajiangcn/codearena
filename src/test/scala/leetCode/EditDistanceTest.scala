package leetCode

import org.scalatest.FunSuite

class EditDistanceTest extends FunSuite {

  test("test sample") {
    val result = new EditDistance().minDistance("abc","bcd")
    // abc -> bcd
    // 1. remove a
    // 2. insert d
    assert(result === 2)
  }

  test("test case 1") {
    val result = new EditDistance().minDistance("plasma", "altruism")
    assert(result === 6)
  }

}
