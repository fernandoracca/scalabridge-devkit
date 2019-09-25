package scalabridge.week3

sealed trait Regex {

  /**
   * Match this regular expression zero or more times
   */
  def repeat: Regex =
    Repeat

  /**
   * Match this regular expression or the given regular expression
   *
   * For example, `Regex.literal("Scala").or(Regex.literal("Stairs"))` with
   * match either "Scala" or "Stairs"
   */
  def or(that: Regex): Regex =
    Or(this, that)

  /**
   * Match this regular expression and then the given regular expression on the
   * remainder.
   *
   * For example, `Regex.literal("Ziggy").andThen(Regex.literal("Stardust")`
   * will match "ZiggyStardust"
   */
  def andThen(that: Regex): Regex =
    And(this, that)

  /**
   * True is this regular expression successfully parses the given `String`,
   * otherwise false.
   */
  def matches(input: String): Boolean =
    this match {
      case Literal(v)  => input.startsWith(v)
      case Or(a, b)  => a.matches(input) || b.matches(input)
      case And(Literal(a), Literal(b))  => Literal(a + b).matches(input)
      case Repeat  => true
      case _ => false
    }
}

case class Literal(value: String) extends Regex
case class Or(a: Regex, b: Regex) extends Regex
case class And(a: Regex, b: Regex) extends Regex
case object Repeat extends Regex


object Regex {

  /**
   * Construct a regular expression that matches the provided `String`.
   *
   * For example, `Regex.literal("Scala")` will match "Scala"
   */
  def literal(value: String): Regex =
    Literal(value)

}