package chaij

import org.scalatest._

trait MessageSpec extends FlatSpec with Matchers {

  type TestedType
  type ExpectationType
  def expectationTypeName: String
  def expect(value: TestedType): ExpectationType
  def expect(value: TestedType, msg: String): ExpectationType
  def constructDummy(msg: String): (String, ExpectationType)

  it should "provide a standardized toString" in {
    val (valString, dummy) = constructDummy("Dummy-Text")
    dummy.toString should equal (s"$expectationTypeName(value=$valString, customText=Dummy-Text)")
  }

  def expectMessage(msg: String)(body: => Unit): Unit = {
    the [UnmetExpectationException] thrownBy body should have message msg
  }

  def registerGoodBadTests[T](
    tests: (TestedType, (ExpectationType, T) => Unit, (String, Seq[T]), (String, Seq[T]))*
  ): Unit = for(
    (testValue, func, (goodMessage, goodValues), (badMessage, badValues)) <- tests
  ) {
    for(goodValue <- goodValues)
      it should goodMessage.format(testValue, goodValue) in {
        func(expect(testValue), goodValue)
      }

    for(badValue <- badValues)
      it should badMessage.format(testValue, badValue) in {
        an [UnmetExpectationException] should be thrownBy func(expect(testValue), badValue)
      }
  }

  def registerGoodBadNullaryTests(
    tests: (ExpectationType => Unit,
      (String, Seq[(String, TestedType)]),
      (String, Seq[(String, TestedType)]))*
  ): Unit = for(
    (func, (goodTemplate, goodValues), (badTemplate, badValues)) <- tests
  ) {
    for((goodMessage, goodValue) <- goodValues)
      it should goodTemplate.format(goodMessage) in {
        func(expect(goodValue))
      }

    for((badMessage, badValue) <- badValues)
      it should badTemplate.format(badMessage) in {
        an [UnmetExpectationException] should be thrownBy func(expect(badValue))
      }
  }

  def registerMessageTests(
    tests: (TestedType, String, String, ExpectationType => Unit, (ExpectationType, String) => Unit)*
  ): Unit = for {
    (value, methodName, failureMsg, withoutMsg, withMsg) <- tests
  } {
    it should s"report a normal '$methodName' message" in {
      expectMessage(failureMsg) {
        withoutMsg(expect(value))
      }
    }

    it should s"accept a given special message on '$methodName'" in {
      expectMessage(s"Special: $failureMsg") {
        withMsg(expect(value), "Special")
      }
    }
  }
}
