package leetCode

import org.scalatest.FunSuite

class CandyTest extends FunSuite {

  test("test candy") {
    val solution = new Candy
    assert(solution.candy(Array(2,2)) === 2)
  }

  test("test candy 1,2,2") {
    val solution = new Candy
    assert(solution.candy(Array(1,2,2)) === 4)
  }

  test("test candy 1,0,2") {
    val solution = new Candy
    assert(solution.candy(Array(1,2,2)) === 5)
  }
}
