package leetCode

import org.scalatest.FunSuite

/**
 * Created by youjiang on 3/17/14.
 */
class ReverseWordInAStringTest extends FunSuite {

  test("test reverse 'the sky is blue'") {
    val rw = new ReverseWordInAString
    val str = "the sky is blue"
    val expectedStr = "blue is sky the"

    assert(rw.reverseWords(str) === expectedStr)

  }

}
