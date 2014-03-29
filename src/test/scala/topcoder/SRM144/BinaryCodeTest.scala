package topcoder.SRM144

import org.scalatest.FunSuite

class BinaryCodeTest extends FunSuite {

  def testutil(message: String, exp: Array[String]) = {
    val solution = new BinaryCode
    val result = solution.decode(message)
    assert(result(0) === exp(0))
    assert(result(1) === exp(1))
  }

  test("test sample inputs") {

    testutil("123210122", Array("011100011", "NONE"))
    testutil("11", Array("01", "10"))
    testutil("22111", Array("NONE", "11001"))
    testutil("123210120", Array("NONE", "NONE"))
    testutil("3", Array("NONE", "NONE"))
    testutil("12221112222221112221111111112221111",
      Array("01101001101101001101001001001101001",
        "10110010110110010110010010010110010"))
  }


}
