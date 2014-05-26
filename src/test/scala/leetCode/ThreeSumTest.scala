package leetCode

import org.scalatest.FunSuite

import scala.collection.JavaConverters._

class ThreeSumTest extends FunSuite {

  test("test sample case") {
    val result = new ThreeSum().threeSum(Array(-1,0,1,2,-1,-4));
    for (res <- result.asScala) {
      println(res.asScala.mkString(","))
    }
  }

}
