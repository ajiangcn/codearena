package leetCode

import org.scalatest.FunSuite

class LongestConsecutiveSequenceTest extends FunSuite {

  test("100,4,200,1,3,2") {
    val sol = new LongestConsecutiveSequence
    assert(sol.longestConsecutive(Array(100,4,200,1,3,2)) === 4)
  }

  test("0,-1") {
    val sol = new LongestConsecutiveSequence
    assert(sol.longestConsecutive(Array(0,-1)) === 2)
  }

  test("1,2,0,1") {
    val sol = new LongestConsecutiveSequence
    assert(sol.longestConsecutive(Array(1,2,0,1)) === 3)
  }

  test("9,1,4,7,3,-1,0,5,8,-1,6") {
    val sol = new LongestConsecutiveSequence
    assert(sol.longestConsecutive(Array(9,1,4,7,3,-1,0,5,8,-1,6)) === 7)
  }
}
