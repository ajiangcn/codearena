package leetCode

import org.scalatest.FunSuite

import MergeKSortedList.ListNode
/**
 * Created by youjiang on 3/17/14.
 */
class MergeKSortedListTest extends FunSuite {

  test("Test merge 2 sorted list") {
    val l1 = new ListNode(1, new ListNode(3))
    val l2 = new ListNode(2, new ListNode(4))

    val solution = new MergeKSortedList
    var result = solution.merge2List(l1, l2)
    val list = scala.collection.mutable.ArrayBuffer[Int]()
    while(result != null) {
      list += result.`val`
      result = result.next
    }
    assert("1,2,3,4" === list.mkString(","))
  }

  test("Test merge 3 lists") {
    val l1 = new ListNode(1, new ListNode(3))
    val l2 = new ListNode(2, new ListNode(4))
    val l3 = new ListNode(5, new ListNode(6))
    val arrayList = new java.util.ArrayList[ListNode]()
    arrayList.add(l1)
    arrayList.add(l2)
    arrayList.add(l3)

    val solution = new MergeKSortedList
    var result = solution.mergeKLists(arrayList)
    val list = scala.collection.mutable.ArrayBuffer[Int]()
    while(result != null) {
      list += result.`val`
      result = result.next
    }
    assert("1,2,3,4,5,6" === list.mkString(","))
  }

  test("Test merge [{},{-1,5,11},{},{6,10}]") {
    val l1 = null
    val l2 = new ListNode(-1, new ListNode(5, new ListNode(11)))
    val l3 = null
    val l4 = new ListNode(6, new ListNode(10))
    val arrayList = new java.util.ArrayList[ListNode]()
    arrayList.add(l1)
    arrayList.add(l2)
    arrayList.add(l3)
    arrayList.add(l4)

    val solution = new MergeKSortedList
    val time = System.currentTimeMillis()
    var result = solution.mergeKLists(arrayList)
    println("time consumed: " + (System.currentTimeMillis() - time))
    val list = scala.collection.mutable.ArrayBuffer[Int]()
    while(result != null) {
      list += result.`val`
      result = result.next
    }
    assert("-1,5,6,10,11" === list.mkString(","))
  }
}
