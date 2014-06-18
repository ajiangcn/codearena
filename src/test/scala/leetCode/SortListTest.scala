package leetCode

import org.scalatest.FunSuite
import leetCode.SortList.{ListNode=>ListNode}

/**
 * Created by youjiang on 3/25/14.
 */
class SortListTest extends FunSuite {

  test("test 3->2->1") {

    val head = new ListNode(3, new ListNode(2, new ListNode(1)))
    val sol = new SortList
    var p = sol.sortList(head)
    while (p != null) {
      println(p.`val`);
      p = p.next
    }
  }
}
