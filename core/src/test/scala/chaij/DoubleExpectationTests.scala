package chaij

import java.util.function.{ DoublePredicate => DPred }

import org.scalatest._
import chaij.ChaiJ.expect

class DoubleExpectationTests extends MessageSpec {

  override type TestedType = Double
  override type ExpectationType = DoubleExpectation
  def expectationTypeName: String = "DoubleExpectation"
  override def expect(value: Double) = ChaiJ.expect(value)
  override def expect(value: Double, msg: String) = ChaiJ.expect(value, msg)
  def constructDummy(msg: String): (String, ExpectationType) = ("1.00000", expect(1.0D, msg))

  behavior of "Double expectations"

  registerGoodBadTests[Double](
    (42D, _ equal _,
     ("make %f be equal to %f", 42D :: Nil),
     ("make %f not be equal to %f", 43D :: Nil)),
    (42D, _ above _,
     ("make %f be above %f", 41D :: Nil),
     ("make %f not be above %f", 42D :: Nil)),
    (42D, _ least _,
     ("make %f be at least %f", 42D :: Nil),
     ("make %f not be at least %f", 43D :: Nil)),
    (42D, _ below _,
     ("make %f be below %f", 43D :: Nil),
     ("make %f not be below %f", 42D :: Nil)),
    (42D, _ most _,
     ("make %f be at most %f", 42D :: Nil),
     ("make %f not be at most %f", 41D :: Nil)),
  )

  registerGoodBadTests[(Double, Double)](
    (42D, (exp, tup) => exp.within(tup._1, tup._2),
     ("make %f be within %s", (42D, 42D) :: (41D, 43D) :: Nil),
     ("make %f not be within %s", (41D, 41D) :: (43D, 43D) :: Nil)),
  )

  registerGoodBadNullaryTests(
    (_.finite(),
      ("make %s a finite double",
        ("42D", 42D) :: Nil),
      ("make %s not a finite double",
        ("Double.PositiveInfinity", Double.PositiveInfinity) ::
        ("Double.NegativeInfinity", Double.NegativeInfinity) :: Nil)),
    (_.infinite(),
      ("make %s an infinite double",
        ("Double.PositiveInfinity", Double.PositiveInfinity) ::
        ("Double.NegativeInfinity", Double.NegativeInfinity) :: Nil),
      ("make %s not an infinite double",
        ("42D", 42D) :: Nil)),
    (_.NaN(),
      ("make %s a NaN",
        ("Double.NaN", Double.NaN) :: Nil),
      ("make %s not a NaN",
        ("42D", 42D) :: Nil)),
  )

  registerGoodBadTests[DPred](
    (42D, _ `match` _,
     ("make %f match _ == 42.0", ((_ == 42D): DPred) :: Nil),
     ("make %f not match _ == 41.0",  ((_ == 41D): DPred) :: Nil)),
    (42D, _ satisfy _,
     ("make %f satisfy _ == 42.0", ((_ == 42D): DPred) :: Nil),
     ("make %f not satisfy _ == 41.0",  ((_ == 41D): DPred) :: Nil)),
  )

  they should "make 42 be close to 42 within 0" in {
    expect(42D).closeTo(42D, 0D)
  }
  they should "make 42 be close to 41 and 43 within 1 each" in {
    expect(42D).closeTo(41D, 1D).closeTo(43D, 1D)
  }
  they should "make 42 not be close to 41 within 0" in {
    an [UnmetExpectationException] should be thrownBy expect(42D).closeTo(41D, 0D)
  }

  they should "make 42 be one of (41, 42, 43)" in {
    expect(42D).oneOf(41D, 42D, 43D)
  }
  they should "make 42 not be one of (41, 43)" in {
    an [UnmetExpectationException] should be thrownBy expect(42D).oneOf(41D, 43D)
  }

  // -- Message tests --

  "The double expectation messages" should "use the standard message" in {
    val exception = the [UnmetExpectationException] thrownBy {
      expect(1D, "Special").equal(2D)
    }
    exception.getMessage should startWith ("Special: ")
  }

  they should behave like registerMessageTests(
    (Double.PositiveInfinity, "finite", "Expected Infinity to be finite.",
      _.finite(), _.finite(_)),
    (42.0D, "infinite", "Expected 42.0 to be infinite.",
      _.infinite(), _.infinite(_)),
    (42.0D, "NaN", "Expected 42.0 to be NaN.",
      _.NaN(), _.NaN(_)),
    (42.0D, "equal", "Expected 42.0 to equal 43.0.",
      _.equal(43.0D), _.equal(43.0D, _)),
    (42.0D, "above", "Expected 42.0 to be above 43.0.",
      _.above(43.0D), _.above(43.0D, _)),
    (42.0D, "least", "Expected 42.0 to be at least 43.0.",
      _.least(43.0D), _.least(43.0D, _)),
    (42.0D, "below", "Expected 42.0 to be below 41.0.",
      _.below(41.0D), _.below(41.0D, _)),
    (42.0D, "most", "Expected 42.0 to be at most 41.0.",
      _.most(41.0D), _.most(41.0D, _)),
    (42.0D, "within", "Expected 42.0 to be within 43.0 and 43.0.",
      _.within(43.0D, 43.0D), _.within(43.0D, 43.0D, _)),
    (42.0D, "match", "Expected 42.0 to match a custom predicate.",
      _.`match`(_ => false), _.`match`(_ => false, _)),
    (42.0D, "satisfy", "Expected 42.0 to satisfy a custom predicate.",
      _.satisfy(_ => false), _.satisfy(_ => false, _)),
    (42.0D, "closeTo", "Expected 42.0 to be close to 43.0 with a delta of 0.0.",
      _.closeTo(43.0D, 0.0D), _.closeTo(43.0D, 0.0D, _)),
    (42.0D, "oneOf", "Expected 42.0 to be one of [41.0, 43.0].",
      _.oneOf(41.0D, 43.0D), _.oneOf(_, 41.0D, 43.0D)),
  )
}
