package leetCode

import LinkedListCycleII.ListNode
import org.scalatest.FunSuite

/**
 * Created by youjiang on 3/22/14.
 */
class LinkedListCycleIITest extends FunSuite {

  test("Test no cycle") {
    val node1 = new ListNode(1)
    val node2 = new ListNode(2)
    val node3 = new ListNode(3)
    node1.next = node2;
    node2.next = node3;

    val solution = new LinkedListCycleII
    assert(solution.detectCycle(node1) === null)
  }

  test("Test cycle 1") {
    val node1 = new ListNode(1)
    val node2 = new ListNode(2)
    val node3 = new ListNode(3)
    node1.next = node2;
    node2.next = node3;
    node3.next = node1;

    val solution = new LinkedListCycleII
    assert(solution.detectCycle(node1) === node1)
  }

  test("Test cycle 2") {
    val node1 = new ListNode(1)
    val node2 = new ListNode(2)
    val node3 = new ListNode(3)
    node1.next = node2;
    node2.next = node3;
    node3.next = node2;

    val solution = new LinkedListCycleII
    assert(solution.detectCycle(node1) === node2)
  }
}
