package scala.algorithmDesignManual.chapter7

import org.scalatest.FunSuite
import algorithmDesignManual.chapter7.AllPermutations

class AllPermutationsTest extends FunSuite {

  test("permutation of abc") {
    val result = new AllPermutations().getAllPermutations("abc")
    println(result);
  }
}
