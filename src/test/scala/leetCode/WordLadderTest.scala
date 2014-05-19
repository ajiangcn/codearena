package scala.leetCode

import org.scalatest.FunSuite
import leetCode.WordLadder
import java.util.HashSet

class WordLadderTest extends FunSuite {

  test("test example case") {
    val start = "hit"
    val end = "cog"
    val dict = new HashSet[String]();
    dict.add("hot");
    dict.add("dot");
    dict.add("dog");
    dict.add("lot");
    dict.add("log");

    val result = new WordLadder().ladderLength(start, end, dict)
    assert(result === 5)
  }

}
