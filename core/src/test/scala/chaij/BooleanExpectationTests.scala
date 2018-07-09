package chaij

import org.scalatest._
import chaij.ChaiJ.expect

class BooleanExpectationTests extends MessageSpec {

  override type TestedType = Boolean
  override type ExpectationType = BooleanExpectation
  def expectationTypeName: String = "BooleanExpectation"
  override def expect(value: Boolean) = ChaiJ.expect(value)
  override def expect(value: Boolean, msg: String) = ChaiJ.expect(value, msg)
  def constructDummy(msg: String): (String, ExpectationType) = ("true", expect(true, msg))

  behavior of "Boolean expectations"

  it should "make true be ok" in {
    expect(true).ok()
  }

  it should "make false not be ok" in {
    an [UnmetExpectationException] should be thrownBy expect(false).ok()
  }

  it should "make true be true" in {
    expect(true)._true()
  }

  it should "make false not be true" in {
    an [UnmetExpectationException] should be thrownBy expect(false)._true()
  }

  it should "make false be false" in {
    expect(false)._false()
  }

  it should "make true not be false" in {
    an [UnmetExpectationException] should be thrownBy expect(true)._false()
  }

  it should "make true equal true" in {
    expect(true).equal(true)
  }

  it should "make false not equal true" in {
    an [UnmetExpectationException] should be thrownBy expect(false).equal(true)
  }

  "The boolean expectation messages" should "use the standard message" in {
    val exception = the [UnmetExpectationException] thrownBy {
      expect(true, "Special").equal(false)
    }
    exception.getMessage should startWith ("Special: ")
  }

  it should behave like registerMessageTests(
    (false, "ok", "Expected a ok-ish boolean.", _.ok(), _.ok(_)),
    (false, "_true", "Expected a true boolean.", _._true(), _._true(_)),
    (true,  "_false", "Expected a false boolean.", _._false(), _._false(_)),
    (false, "equal", "Expected false to equal true.", _.equal(true), _.equal(true, _)),
  )
}
