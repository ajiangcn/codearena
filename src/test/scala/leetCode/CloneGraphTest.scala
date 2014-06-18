package leetCode

import CloneGraph.UndirectedGraphNode
import org.scalatest.FunSuite

/**
 * Created by youjiang on 3/20/14.
 */
class CloneGraphTest extends FunSuite {

  test("Test cloning graph") {
    val node1 = new UndirectedGraphNode(1)
    val node2 = new UndirectedGraphNode(2)
    val node3 = new UndirectedGraphNode(3)

    node1.neighbors.add(node2)
    node1.neighbors.add(node3)

    val solution =  new CloneGraph
    val result = solution.cloneGraph(node1)

    assert(result.label === node1.label)
  }

}
