package leetCode

import org.scalatest.FunSuite

class DistinctSubsequencesTest extends FunSuite {

  test("S=rabbbit T=rabbit") {
    assert(3 === new DistinctSubsequencess().numDistinct("rabbbit", "rabbit"))
    assert(3 === new DistinctSubsequencess().numDistinct("ccc", "c"))

    println(
      new DistinctSubsequencess().numDistinct("aabdbaabeeadcbbdedacbbeecbabebaeeecaeabaedadcbdbcdaabebdadbbaeabdadeaabbabbecebbebcaddaacccebeaeedababedeacdeaaaeeaecbe", "bddabdcae"));
  }

}
