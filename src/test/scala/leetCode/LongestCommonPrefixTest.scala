package leetCode

import org.scalatest.FunSuite

/**
 * Created by youjiang on 3/24/14.
 */
class LongestCommonPrefixTest extends FunSuite {

  test("test single string") {
    val sol = new LongestCommonPrefix

    assert("abcd" === sol.longestCommonPrefix(Array("abcd")))
  }

  test("test empty strs") {
    val sol = new LongestCommonPrefix

    assert(sol.longestCommonPrefix(Array()) === null)
    assert(sol.longestCommonPrefix(Array("")) === "")
  }

  test("test two strings") {
    val sol = new LongestCommonPrefix
    assert(sol.longestCommonPrefix(Array("abc", "abcdefg")) === "abc")
  }

  test("test three strings") {
    val sol = new LongestCommonPrefix
    assert(sol.longestCommonPrefix(Array("abcd", "abcdefg", "abc")) === "abc")
  }
}
