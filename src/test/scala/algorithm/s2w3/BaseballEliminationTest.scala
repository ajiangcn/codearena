package algorithm.s2w3

import org.scalatest.FunSuite
import java.io.File

class BaseballEliminationTest extends FunSuite {

  test("test construct baseball elimination from file") {
    val file = getClass.getResource("teams4.txt");
    val be = new BaseballElimination(file.getPath);
    assert(be.numberOfTeam() === 4)

    val file1 = getClass.getResource("teams5.txt");
    val be1 = new BaseballElimination(file1.getPath);
    assert(be1.numberOfTeam() === 5)
  }
}
