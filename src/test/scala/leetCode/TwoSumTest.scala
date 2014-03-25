package leetCode

import org.scalatest.FunSuite

/**
 * Created by youjiang on 3/17/14.
 */
class TwoSumTest extends FunSuite{

  test("test the simple example") {
    val numbers = Array(2,7,11,15)
    val target = 9

    val twoSum = new TwoSum
    val result = twoSum.twoSum(numbers, target)
    assert(result(0) === 1)
    assert(result(1) === 2)
  }

  test("test 3,2,4 target = 6") {
    val numbers = Array(3,2,4)
    val target = 6

    val twoSum = new TwoSum
    val result = twoSum.twoSum(numbers, target)
    assert(result(0) === 2)
    assert(result(1) === 3)
  }

  test("test 5,75,25 target = 100") {
    val numbers = Array(5,75,25)
    val target = 100

    val twoSum = new TwoSum
    val result = twoSum.twoSum(numbers, target)
    assert(result(0) === 2)
    assert(result(1) === 3)
  }

  test("test 0,4,3,0 target = 0") {
    val numbers = Array(0,4,3,0)
    val target = 0

    val twoSum = new TwoSum
    val result = twoSum.twoSum(numbers, target)
    assert(result(0) === 1)
    assert(result(1) === 4)
  }

  test("test quick sort with simple case") {
    val twoSum = new TwoSum
    val arrays = Array(2,11,15,9);
    val result = twoSum.quickSort(arrays,0, arrays.length-1)

    assert(result === Array(2,9,11,15))
  }

  test("test simple binary search") {
    val twoSum = new TwoSum
    val arrays = Array(2,9,11,15)

    assert(twoSum.binarySearch(arrays, 0, 11) === true)
    assert(twoSum.binarySearch(arrays, 0, 12) === false)
  }

  test("test simple get index") {
    val twoSum = new TwoSum
    val arrays = Array(2,9,11,15)

    assert(twoSum.getIndex(arrays, 0, 9) == 1)
    assert(twoSum.getIndex(arrays, 0, 16) == -1)
  }
}
