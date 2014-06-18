package others

import org.scalatest.FunSuite

class QuickSortTest extends FunSuite {

  test("Test 1,2,3,4") {
    val input = Array(Integer.valueOf(1),Integer.valueOf(2),Integer.valueOf(3),Integer.valueOf(4))
    val expectedResult = Array(Integer.valueOf(1),Integer.valueOf(2),Integer.valueOf(3),Integer.valueOf(4))
    QuickSort.sort(input)
    assert(input === expectedResult)
  }

  test("Test 4,3,2,1") {
    val input = Array(Integer.valueOf(4),Integer.valueOf(3),Integer.valueOf(2),Integer.valueOf(1))
    val expectedResult = Array(Integer.valueOf(1),Integer.valueOf(2),Integer.valueOf(3),Integer.valueOf(4))
    QuickSort.sort(input)
    assert(input === expectedResult)
  }
}
