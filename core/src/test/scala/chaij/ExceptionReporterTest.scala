package chaij

import org.scalatest._
import chaij.ChaiJ.expect
import chaij.ExceptionReporter.{ runMultipleAndReport, reportException, MultipleException }

class ExceptionReporterTests extends FlatSpec with Matchers with OptionValues {

  behavior of "The exception reporter"

  it should "rethrow an error in single report mode" in {
    the [UnmetExpectationException] thrownBy {
      reportException(new UnmetExpectationException("Some Error!"))
    } should have message "Some Error!"
  }

  it should "do nothing when no exceptions are thrown in multiple report mode" in {
    runMultipleAndReport { () =>
      // nothing happens!
    }
  }

  it should "report a single exception in multiple report mode by rethrowing it" in {
    the [UnmetExpectationException] thrownBy {
      runMultipleAndReport { () =>
        reportException(new UnmetExpectationException("Some Error!"))
      }
    } should have message "Some Error!"
  }

  it should "report multiple exceptions in multiple report mode by packaging them" in {
    val exception = the [MultipleException] thrownBy {
      runMultipleAndReport { () =>
        reportException(new UnmetExpectationException("Some error 1!"))
        reportException(new UnmetExpectationException("Some error 2!"))
      }
    }

    exception.getMessage.lines.toList should === (
      "There were 2 errors:" ::
      " - chaij.UnmetExpectationException(Some error 1!)" ::
      " - chaij.UnmetExpectationException(Some error 2!)" ::
      Nil
    )
  }

  it should "package an unexpected exception as well as normal reported exceptions in multiple report mode" in {
    val exception = the [MultipleException] thrownBy {
      runMultipleAndReport { () =>
        reportException(new UnmetExpectationException("Some error 1!"))
        throw new RuntimeException("Abnormal! HELP!")
      }
    }

    exception.getMessage.lines.toList should === (
      "There were 2 errors:" ::
      " - chaij.UnmetExpectationException(Some error 1!)" ::
      " - chaij.WrappedCheckedException(java.lang.RuntimeException: Abnormal! HELP!) with cause" ::
      "    java.lang.RuntimeException(Abnormal! HELP!)" ::
      Nil
    )
  }

  it should "work with another thread as well" in {
    var thrownException: Option[Throwable] = None

    val t: Thread = new Thread(() => reportException(new UnmetExpectationException("Some error!")))
    t.setUncaughtExceptionHandler((_, ex) => thrownException = Some(ex))
    t.start()
    t.join()

    thrownException.value shouldBe a [UnmetExpectationException]
    thrownException.value should have message "Some error!"
  }
}
