package leetCode

import org.scalatest.FunSuite

class PowTest extends FunSuite {

  test("5 * 5 = 25") {
    assert(new Pow().pow(5d,2) === 25d)
    assert(new Pow().pow(5d,3) === 125d)
    assert(new Pow().pow(0.00001, 2147483647) === 0d)
    assert(new Pow().pow(1d, -2147483648) === 1d)
  }

  test(" tail recursion 5 * 5 = 25") {
    assert(new Pow().powTR(5d,2) === 25d)
    assert(new Pow().powTR(5d,3) === 125d)
    assert(new Pow().powTR(0.00001, 2147483647) === 0d)
    assert(new Pow().powTR(1d, -2147483648) === 1d)
  }

}
