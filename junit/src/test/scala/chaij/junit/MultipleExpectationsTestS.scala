package chaij
package junit

import org.scalatest._

import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runner.Description.{ createTestDescription => testDesc, EMPTY => EMPTY_DESC }
import org.junit.runners.model.Statement

import java.lang.annotation.{ Annotation => JAnnot }

import chaij.ChaiJ.expect
import chaij.ExceptionReporter.MultipleException
import chaij.UnmetExpectationException

class MultipleExpectationsTestS extends FlatSpec with Matchers {

  val allRule:  TestRule = MultipleExpectations.all()
  val noneRule: TestRule = MultipleExpectations.none()

  @MultipleExpectation def multiple = getClass.getMethod("multiple").getAnnotation(classOf[MultipleExpectation])
  @SingleExpectation   def single   = getClass.getMethod("single"  ).getAnnotation(classOf[SingleExpectation]  )

  private def run(rule: TestRule, description: Description = EMPTY_DESC)(code: => Unit) = {
    rule.apply(new Statement() {
      override def evaluate(): Unit = code
    }, description).evaluate()
  }

  "MultipleExpectation.all" should "accept a single truth" in {
    run(allRule) {
      expect(true).to.be.ok()
    }
  }

  it should "report a single falsehood" in {
    val caught = intercept[UnmetExpectationException] {
      run(allRule) {
        expect(false).to.be.ok()
      }
    }

    caught.getMessage should === ("Expected a ok-ish boolean.")
  }

  it should "report multiple falsehoods" in {
    val caught = intercept[MultipleException] {
      run(allRule) {
        expect(false).to.be.ok()
        expect(2).to.be.above(3)
      }
    }

    caught.getMessage should === (
      """There were 2 errors:
        | - chaij.UnmetExpectationException(Expected a ok-ish boolean.)
        | - chaij.UnmetExpectationException(Expected 2 to be above 3.)""".stripMargin
    )
  }

  it should "correctly recognize the 'single' annotation" in {
    val caught = intercept[UnmetExpectationException] {
      run(allRule, testDesc(getClass, "exceptionForSingle", single)) {
        expect(false).to.be.ok()
        expect(2).to.be.above(3)
      }
    }

    caught.getMessage should === ("Expected a ok-ish boolean.")
  }

  it should "correctly ignore the 'multiple' annotation" in {
    val caught = intercept[MultipleException] {
      run(allRule, testDesc(getClass, "noExceptionForMultiple", multiple)) {
        expect(false).to.be.ok()
        expect(2).to.be.above(3)
      }
    }

    caught.getMessage should === (
      """There were 2 errors:
        | - chaij.UnmetExpectationException(Expected a ok-ish boolean.)
        | - chaij.UnmetExpectationException(Expected 2 to be above 3.)""".stripMargin
    )
  }

  "MultipleExpectation.none" should "accept a single truth" in {
    run(noneRule) {
      expect(true).to.be.ok()
    }
  }

  it should "report a single falsehood" in {
    val caught = intercept[UnmetExpectationException] {
      run(noneRule) {
        expect(false).to.be.ok()
      }
    }

    caught.getMessage should === ("Expected a ok-ish boolean.")
  }

  it should "not report multiple falsehoods" in {
    val caught = intercept[UnmetExpectationException] {
      run(noneRule) {
        expect(false).to.be.ok()
        expect(2).to.be.above(3)
      }
    }

    caught.getMessage should === ("Expected a ok-ish boolean.")
  }

  it should "correctly recognize the 'multiple' annotation" in {
    val caught = intercept[MultipleException] {
      run(noneRule, testDesc(getClass, "exceptionForMultiple", multiple)) {
        expect(false).to.be.ok()
        expect(2).to.be.above(3)
      }
    }

    caught.getMessage should === (
      """There were 2 errors:
        | - chaij.UnmetExpectationException(Expected a ok-ish boolean.)
        | - chaij.UnmetExpectationException(Expected 2 to be above 3.)""".stripMargin
    )
  }

  it should "correctly ignore the 'single' annotation" in {
    val caught = intercept[UnmetExpectationException] {
      run(noneRule, testDesc(getClass, "noExceptionForSingle", single)) {
        expect(false).to.be.ok()
        expect(2).to.be.above(3)
      }
    }

    caught.getMessage should === ("Expected a ok-ish boolean.")
  }
}
