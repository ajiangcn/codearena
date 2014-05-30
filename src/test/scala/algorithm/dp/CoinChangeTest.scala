package algorithm.dp

import org.scalatest.FunSuite

class CoinChangeTest extends FunSuite {

  test("Test N=4 S={1,2,3}") {
    val result = new CoinChange().numOfWays(4, Array(1,2,3));
    assert(result === 4)
  }

  test("Test N=10, S={2,5,3,6}") {
    val result = new CoinChange().numOfWays(10, Array(2,5,3,6));
    assert(result === 5)
  }

}
