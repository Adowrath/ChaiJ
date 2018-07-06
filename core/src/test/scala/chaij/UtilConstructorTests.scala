package chaij

import org.scalatest._

import java.lang.reflect.InvocationTargetException

class UtilConstructorTests extends FlatSpec with Matchers {
  "The exception reporter constructor" should "disallow instantiation" in {
    val exception = intercept[InvocationTargetException] {
      val cons = classOf[ExceptionReporter].getDeclaredConstructor()
      cons.setAccessible(true)
      cons.newInstance()
    }
    exception.getCause shouldBe an [IllegalAccessException]
  }

  "The chaij constructor" should "disallow instantiation" in {
    val exception = intercept[InvocationTargetException] {
      val cons = classOf[ChaiJ].getDeclaredConstructor()
      cons.setAccessible(true)
      cons.newInstance()
    }
    exception.getCause shouldBe an [IllegalAccessException]
  }
}
