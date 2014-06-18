package algorithm.stringmatch

import org.scalatest.FunSuite

class KMPTest extends FunSuite {


  test("test pattern match") {
    val input = "AABAACAADAABAAABAA"
    val pattern = "AABA"
    new KMP().KMPSearch(pattern, input)

    new KMP().KMPSearch("TEST", "THIS IS A TEST TEXT")
    new KMP().KMPSearch("ABABCABAB", "ABABDABACDABABCABAB")
  }

  test("test generating longest proper prefix") {

    val result1 = new KMP().computeLongestProperPrefix("AABAACAABAA")
    val expectedResult1 = Array(0,1,0,1,2,0,1,2,3,4,5)
    assert(result1 === expectedResult1)

    val result2 = new KMP().computeLongestProperPrefix("ABCDE")
    val expectedResult2 = Array(0, 0, 0, 0, 0)
    assert(result2 === expectedResult2)

    val result3 = new KMP().computeLongestProperPrefix("AAAAA")
    val expectedResult3 = Array(0, 1, 2, 3, 4)
    assert(result3 === expectedResult3)

    val result4 = new KMP().computeLongestProperPrefix("AAABAAA")
    val expectedResult4 = Array(0, 1, 2, 0, 1, 2, 3)
    assert(result4 === expectedResult4)

    val result5 = new KMP().computeLongestProperPrefix("AAACAAAAAC")
    val expectedResult5 = Array(0, 1, 2, 0, 1, 2, 3, 3, 3, 4)
    assert(result5 === expectedResult5)
  }

}
