package scalabridge.week3

import org.scalatest.{FreeSpec, Matchers}

class NaiveRegexCalcTest extends FreeSpec with Matchers {

  "Trivial expressions" - {
    "should succeed" - {
      "when parsing addition with no spaces" in {
        NaiveRegexCalc.parse("3+1").isRight should be(true)
      }

      "when parsing addition with spaces" in {
        NaiveRegexCalc.parse("2 + 5").isRight should be(true)
      }

      "when parsing substraction with spaces" in {
        NaiveRegexCalc.parse("2 - 5").isRight should be(true)
      }

      "when parsing addition with many spaces" in {
        NaiveRegexCalc.parse("  8 + 4").isRight should be(true)
      }

      "when parsing larger numbers" in {
        NaiveRegexCalc.parse(" 365 +876 ").isRight should be(true)
      }
    }
  }
  "larger expressions won't parse" - {
    "since parser is not recursive" - {
      "when parsing addition with no spaces" in {
        NaiveRegexCalc.parse("1 + 2 + 3").isLeft should be(true)
      }
    }
  }

}
