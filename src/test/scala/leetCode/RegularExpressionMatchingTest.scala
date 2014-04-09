package leetCode

import org.scalatest.FunSuite

class RegularExpressionMatchingTest extends FunSuite {

  test("test sample cases") {
    val sol = new RegularExpressionMatching
    assert(sol.isMatch("aa", "a") === false)
    assert(sol.isMatch("aa", "aa") === true)
    assert(sol.isMatch("aaa", "aa") === false)
    assert(sol.isMatch("aa", "a*") === true)
    assert(sol.isMatch("aa", ".*") === true)
    assert(sol.isMatch("ab", ".*") === true)
    assert(sol.isMatch("aab", "c*a*b") === true)
  }

}
