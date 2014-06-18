package scala.leetCode

import org.scalatest.FunSuite
import leetCode.NQueens
import scala.collection.JavaConverters._;

class NQueensTest extends FunSuite {

  test ("test 4 queens") {
    val sol = new NQueens();
    val result = sol.solveNQueens(4).asScala;
    println(result.size)
    result.map(x => println(x.mkString("\n") + "\n\n++++++++++++++++\n"));
  }

}
