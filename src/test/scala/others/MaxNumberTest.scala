package others

import org.scalatest.FunSuite

class MaxNumberTest extends FunSuite {

  test("test 123,1200") {
    assert(MaxNumber.maxNumber(123) === 321)
    assert(MaxNumber.maxNumber(1200) === 2100)
  }

}
