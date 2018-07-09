package chaij

import java.util.function.{ IntPredicate => IPred }

import org.scalatest._
import chaij.ChaiJ.expect

class IntExpectationTests extends MessageSpec {

  override type TestedType = Int
  override type ExpectationType = IntExpectation
  def expectationTypeName: String = "IntExpectation"
  override def expect(value: Int) = ChaiJ.expect(value)
  override def expect(value: Int, msg: String) = ChaiJ.expect(value, msg)
  def constructDummy(msg: String): (String, ExpectationType) = ("1", expect(1, msg))

  behavior of "Long expectations"

  registerGoodBadTests[Int](
    (42, _ equal _,
     ("make %d be equal to %d", 42 :: Nil),
     ("make %d not be equal to %d", 43 :: Nil)),
    (42, _ above _,
     ("make %d be above %d", 41 :: Nil),
     ("make %d not be above %d", 42 :: Nil)),
    (42, _ least _,
     ("make %d be at least %d", 42 :: Nil),
     ("make %d not be at least %d", 43 :: Nil)),
    (42, _ below _,
     ("make %d be below %d", 43 :: Nil),
     ("make %d not be below %d", 42 :: Nil)),
    (42, _ most _,
     ("make %d be at most %d", 42 :: Nil),
     ("make %d not be at most %d", 41 :: Nil)),
  )

  registerGoodBadTests[(Int, Int)](
    (42, (exp, tup) => exp.within(tup._1, tup._2),
     ("make %d be within %s", (42, 42) :: (41, 43) :: Nil),
     ("make %d not be within %s", (41, 41) :: (43, 43) :: Nil)),
  )

  registerGoodBadTests[IPred](
    (42, _ `match` _,
     ("make %d match _ == 42", ((_ == 42): IPred) :: Nil),
     ("make %d not match _ == 41",  ((_ == 41): IPred) :: Nil)),
    (42, _ satisfy _,
     ("make %d satisfy _ == 42", ((_ == 42): IPred) :: Nil),
     ("make %d not satisfy _ == 41",  ((_ == 41): IPred) :: Nil)),
  )

  they should "make 42 be close to 42 within 0" in {
    expect(42).closeTo(42, 0)
  }
  they should "make 42 be close to 41 and 43 within 1 each" in {
    expect(42).closeTo(41, 1).closeTo(43, 1)
  }
  they should "make 42 not be close to 41 within 0" in {
    an [UnmetExpectationException] should be thrownBy expect(42).closeTo(41, 0)
  }

  they should "make 42 be one of (41, 42, 43)" in {
    expect(42).oneOf(41, 42, 43)
  }
  they should "make 42 not be one of (41, 43)" in {
    an [UnmetExpectationException] should be thrownBy expect(42).oneOf(41, 43)
  }

  registerGoodBadNullaryTests(
    (_.validShort(),
      ("make %s be a valid Short",
        ("Short.MaxValue", Short.MaxValue.toInt) :: Nil),
      ("make %s not be a valid Short",
        ("Short.MaxValue + 1", Short.MaxValue.toInt + 1) ::
        ("Short.MinValue - 1", Short.MinValue.toInt - 1) :: Nil)),
    (_.validByte(),
      ("make %s be a valid Byte",
        ("Byte.MaxValue", Byte.MaxValue.toInt) :: Nil),
      ("make %s not be a valid Byte",
        ("Byte.MaxValue + 1", Byte.MaxValue.toInt + 1) ::
        ("Byte.MinValue - 1", Byte.MinValue.toInt - 1) :: Nil)),
  )

  "The int expectation messages" should "use the standard message" in {
    val exception = the [UnmetExpectationException] thrownBy {
      expect(1, "Special").equal(2)
    }
    exception.getMessage should startWith ("Special: ")
  }

  they should behave like registerMessageTests(
    (42, "equal", "Expected 42 to equal 43.",
      _.equal(43), _.equal(43, _)),
    (42, "above", "Expected 42 to be above 43.",
      _.above(43), _.above(43, _)),
    (42, "least", "Expected 42 to be at least 43.",
      _.least(43), _.least(43, _)),
    (42, "below", "Expected 42 to be below 41.",
      _.below(41), _.below(41, _)),
    (42, "most", "Expected 42 to be at most 41.",
      _.most(41), _.most(41, _)),
    (42, "within", "Expected 42 to be within 43 and 43."
      , _.within(43, 43), _.within(43, 43, _)),
    (42, "match", "Expected 42 to match a custom predicate.",
      _.`match`(_ => false), _.`match`(_ => false, _)),
    (42, "satisfy", "Expected 42 to satisfy a custom predicate.",
      _.satisfy(_ => false), _.satisfy(_ => false, _)),
    (42, "closeTo", "Expected 42 to be close to 43 with a delta of 0.",
      _.closeTo(43, 0), _.closeTo(43, 0, _)),
    (42, "oneOf", "Expected 42 to be one of [41, 43].",
      _.oneOf(41, 43), _.oneOf(_, 41, 43)),
    (Byte.MaxValue + 1, "validByte", "Expected 128 to be a valid byte value.",
      _.validByte(), _.validByte(_)),
    (Short.MaxValue + 1, "validShort", "Expected 32768 to be a valid short value.",
      _.validShort(), _.validShort(_)),
  )
}
