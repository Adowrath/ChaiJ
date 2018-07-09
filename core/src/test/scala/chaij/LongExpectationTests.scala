package chaij

import java.util.function.{ LongPredicate => LPred }

import org.scalatest._
import chaij.ChaiJ.expect

class LongExpectationTests extends MessageSpec {

  override type TestedType = Long
  override type ExpectationType = LongExpectation
  def expectationTypeName: String = "LongExpectation"
  override def expect(value: Long) = ChaiJ.expect(value)
  override def expect(value: Long, msg: String) = ChaiJ.expect(value, msg)
  def constructDummy(msg: String): (String, ExpectationType) = ("1", expect(1L, msg))

  behavior of "Long expectations"

  registerGoodBadTests[Long](
    (42L, _ equal _,
     ("make %d be equal to %d", 42L :: Nil),
     ("make %d not be equal to %d", 43L :: Nil)),
    (42L, _ above _,
     ("make %d be above %d", 41L :: Nil),
     ("make %d not be above %d", 42L :: Nil)),
    (42L, _ least _,
     ("make %d be at least %d", 42L :: Nil),
     ("make %d not be at least %d", 43L :: Nil)),
    (42L, _ below _,
     ("make %d be below %d", 43L :: Nil),
     ("make %d not be below %d", 42L :: Nil)),
    (42L, _ most _,
     ("make %d be at most %d", 42L :: Nil),
     ("make %d not be at most %d", 41L :: Nil)),
  )

  registerGoodBadTests[(Long, Long)](
    (42L, (exp, tup) => exp.within(tup._1, tup._2),
     ("make %d be within %s", (42L, 42L) :: (41L, 43L) :: Nil),
     ("make %d not be within %s", (41L, 41L) :: (43L, 43L) :: Nil)),
  )

  registerGoodBadTests[LPred](
    (42L, _ `match` _,
     ("make %d match _ == 42", ((_ == 42L): LPred) :: Nil),
     ("make %d not match _ == 41",  ((_ == 41L): LPred) :: Nil)),
    (42L, _ satisfy _,
     ("make %d satisfy _ == 42", ((_ == 42L): LPred) :: Nil),
     ("make %d not satisfy _ == 41",  ((_ == 41L): LPred) :: Nil)),
  )

  they should "make 42 be close to 42 within 0" in {
    expect(42L).closeTo(42L, 0L)
  }
  they should "make 42 be close to 41 and 43 within 1 each" in {
    expect(42L).closeTo(41L, 1L).closeTo(43L, 1L)
  }
  they should "make 42 not be close to 41 within 0" in {
    an [UnmetExpectationException] should be thrownBy expect(42L).closeTo(41L, 0L)
  }

  they should "make 42 be one of (41, 42, 43)" in {
    expect(42L).oneOf(41L, 42L, 43L)
  }
  they should "make 42 not be one of (41, 43)" in {
    an [UnmetExpectationException] should be thrownBy expect(42L).oneOf(41L, 43L)
  }

  registerGoodBadNullaryTests(
    (_.validInt(),
      ("make %s be a valid Int",
        ("Int.MaxValue", Int.MaxValue.toLong) :: Nil),
      ("make %s not be a valid Int",
        ("Int.MaxValue + 1", Int.MaxValue.toLong + 1) ::
        ("Int.MinValue - 1", Int.MinValue.toLong - 1) :: Nil)),
    (_.validShort(),
      ("make %s be a valid Short",
        ("Short.MaxValue", Short.MaxValue.toLong) :: Nil),
      ("make %s not be a valid Short",
        ("Short.MaxValue + 1", Short.MaxValue.toLong + 1) ::
        ("Short.MinValue - 1", Short.MinValue.toLong - 1) :: Nil)),
    (_.validByte(),
      ("make %s be a valid Byte",
        ("Byte.MaxValue", Byte.MaxValue.toLong) :: Nil),
      ("make %s not be a valid Byte",
        ("Byte.MaxValue + 1", Byte.MaxValue.toLong + 1) ::
        ("Byte.MinValue - 1", Byte.MinValue.toLong - 1) :: Nil)),
  )

  "The long expectation messages" should "use the standard message" in {
    val exception = the [UnmetExpectationException] thrownBy {
      expect(1L, "Special").equal(2L)
    }
    exception.getMessage should startWith ("Special: ")
  }

  they should behave like registerMessageTests(
    (42L, "equal", "Expected 42 to equal 43.",
      _.equal(43L), _.equal(43L, _)),
    (42L, "above", "Expected 42 to be above 43.",
      _.above(43L), _.above(43L, _)),
    (42L, "least", "Expected 42 to be at least 43.",
      _.least(43L), _.least(43L, _)),
    (42L, "below", "Expected 42 to be below 41.",
      _.below(41L), _.below(41L, _)),
    (42L, "most", "Expected 42 to be at most 41.",
      _.most(41L), _.most(41L, _)),
    (42L, "within", "Expected 42 to be within 43 and 43."
      , _.within(43L, 43L), _.within(43L, 43L, _)),
    (42L, "match", "Expected 42 to match a custom predicate.",
      _.`match`(_ => false), _.`match`(_ => false, _)),
    (42L, "satisfy", "Expected 42 to satisfy a custom predicate.",
      _.satisfy(_ => false), _.satisfy(_ => false, _)),
    (42L, "closeTo", "Expected 42 to be close to 43 with a delta of 0.",
      _.closeTo(43L, 0L), _.closeTo(43L, 0L, _)),
    (42L, "oneOf", "Expected 42 to be one of [41, 43].",
      _.oneOf(41L, 43L), _.oneOf(_, 41L, 43L)),
    (Byte.MaxValue + 1L, "validByte", "Expected 128 to be a valid byte value.",
      _.validByte(), _.validByte(_)),
    (Short.MaxValue + 1L, "validShort", "Expected 32768 to be a valid short value.",
      _.validShort(), _.validShort(_)),
    (Int.MaxValue + 1L, "validInt", "Expected 2147483648 to be a valid integer value.",
      _.validInt(), _.validInt(_)),
  )
}
