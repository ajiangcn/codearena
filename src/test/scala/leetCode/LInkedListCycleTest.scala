package leetCode

import LInkedListCycle.ListNode
import org.scalatest.FunSuite

/**
 * Created by youjiang on 3/22/14.
 */
class LInkedListCycleTest extends FunSuite {

  test("Test no cycle") {
    val node1 = new ListNode(1)
    val node2 = new ListNode(2)
    val node3 = new ListNode(3)
    node1.next = node2;
    node2.next = node3;

    val solution = new LInkedListCycle
    assert(solution.hasCycle(node1) === false)
  }

  test("Test cycle 1") {
    val node1 = new ListNode(1)
    val node2 = new ListNode(2)
    val node3 = new ListNode(3)
    node1.next = node2;
    node2.next = node3;
    node3.next = node1;

    val solution = new LInkedListCycle
    assert(solution.hasCycle(node1) === true)
  }

  test("Test cycle 2") {
    val node1 = new ListNode(1)
    val node2 = new ListNode(2)
    val node3 = new ListNode(3)
    node1.next = node2;
    node2.next = node3;
    node3.next = node2;

    val solution = new LInkedListCycle
    assert(solution.hasCycle(node1) === true)
  }
}
