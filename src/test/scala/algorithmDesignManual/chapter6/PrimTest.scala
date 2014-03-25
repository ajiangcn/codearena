package algorithmDesignManual.chapter6

import org.scalatest.FunSuite

/**
 * Created by youjiang on 3/23/14.
 */
class PrimTest extends FunSuite {

  test("Test greedy method") {
    val g = new Graph

    g.directed = 0;

    val edge1 = new EdgeNode(2, 1, new EdgeNode(3, 3, null))
    val edge2 = new EdgeNode(1, 1, new EdgeNode(3, 2, null))
    val edge3 = new EdgeNode(1, 3, new EdgeNode(2, 2, null))
    g.edges = Array(null, edge1, edge2, edge3)
    g.nvertices = 3;
    g.nedges = 3;


    val solution = new Prim
    solution.prim(g, 2)
  }
}
