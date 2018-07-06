package chaij

import org.scalatest._
import org.mockito.Mockito.{ mock => mockIt }

class BaseExpectationTests extends FlatSpec with Matchers {
  private class DummyExpectation(msg: String) extends BaseExpectation[DummyExpectation](msg)
  private def dummy(message: String = null): DummyExpectation = new DummyExpectation(message)
  private def mock(): DummyExpectation = mockIt(classOf[DummyExpectation])

  "The basic expectation" should "return itself on the normal linkers" in {
    val expectation = dummy()
    expectation
      .to.be.been.is
      .that.which.and.has
      .have.`with`.at.of
      .same should be theSameInstanceAs expectation
  }

  it should "do nothing on a passing test" in {
    mock().test(true, "This should not fail.", "But it did!")
  }

  it should "simply throw on a failing test" in {
    the [UnmetExpectationException] thrownBy {
      mock().test(false, "This should fail.", "And it did!")
    } should have message "This should fail. And it did!"
  }

  it should "respect the not flag on a failing test" in {
    mock().not().test(false, "This should not fail.", "But it did!")
  }

  it should "respect the not flag on a passing test" in {
    the [UnmetExpectationException] thrownBy {
      mock().not().test(true, "This should fail. Here come's a not: '", "'. And that was the not.")
    } should have message "This should fail. Here come's a not: ' not '. And that was the not."
  }

  it should "revert to old behaviour on doubly not" in {
    mock().not().not().test(true, "This should not fail.", "But it did!`")
  }

  it should "use a custom message in failing tests" in {
    the [UnmetExpectationException] thrownBy {
      mock().test(false, "Custom message", "This should fail.", "And it did!")
    } should have message "Custom message: This should fail. And it did!"
  }

  it should "use a message from the expectation itself when failing" in {
    the [UnmetExpectationException] thrownBy {
      dummy("Custom message").test(false, "This should fail.", "And it did!")
    } should have message "Custom message: This should fail. And it did!"
  }

  it should "work with a lazy second in failing tests" in {
    the [UnmetExpectationException] thrownBy {
      mock().test(false, "Custom message", "This should fail.", () => "And it did!")
    } should have message "Custom message: This should fail. And it did!"
  }

  it should "respect the continue after fail behaviour by the ExceptionReporter" in {
    val expectation = dummy()
    the [UnmetExpectationException] thrownBy {
      ExceptionReporter.runMultipleAndReport { () =>
        val afterTest = expectation.test(false, "A", "B")

        afterTest should be theSameInstanceAs expectation
      }
      mock().test(false, "Custom message", "This should fail.", () => "And it did!")
    } should have message "A B"
  }
}
