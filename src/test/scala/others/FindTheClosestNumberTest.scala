package others

import org.scalatest.FunSuite

class FindTheClosestNumberTest extends FunSuite {

  test("test a=1,2,3,4,5 key = 6") {
    assert(FindTheClosestNumber.find(Array(1,2,3,4,5), 6) == 4)
  }

  test("test a=1,2,3,4,5 key = 0") {
    assert(FindTheClosestNumber.find(Array(1,2,3,4,5), 0) == 0)
  }

  test("test a=1,2,3,4,7 key = 6") {
    assert(FindTheClosestNumber.find(Array(1,2,3,4,7), 6) == 4)
  }
}
