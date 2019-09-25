package scalabridge.week3

import org.scalatest.FunSuite

class RegexSuite extends FunSuite {

  test("Literal matches exact literal string") {
    assert(Regex.literal("Iambic 9 poetry").matches("Iambic 9 poetry"))
    assert(Regex.literal("Dreamer").matches("Dreamer"))
    assert(Regex.literal("Aurelia").matches("Aurelia"))
  }

  test("Literal matches string starting with the literal") {
    assert(Regex.literal("Iambic 9").matches("Iambic 9 poetry"))
    assert(Regex.literal("Drea").matches("Dreamer"))
    assert(Regex.literal("Aure").matches("Aurelia"))
  }

  test("or matches either alternative") {
    assert(Regex.literal("Pull").or(Regex.literal("Push")).matches("Push"))
    assert(Regex.literal("Pull").or(Regex.literal("Push")).matches("Pull"))
  }

  test("andThen matches in sequence") {
    assert(Regex.literal("Holly").andThen(Regex.literal("Herndon")).matches("HollyHerndon"))
    assert(Regex.literal("Holly").andThen(Regex.literal("Herndon")).matches("HollyHerndon and other stuff"))
  }

  test("Repeat matches zero repeats") {
    assert(Regex.literal("Monolake").repeat.matches("Quick Eternity"))
    assert(Regex.literal("Monolake").repeat.matches(""))
    assert(Regex.literal("Monolake").repeat.matches("Loscil"))
  }

  test("Repeat matches one or more repeats") {
    assert(Regex.literal("Monolake").repeat.matches("Monolake"))
    assert(Regex.literal("Monolake").repeat.matches("MonolakeMonolake"))
    assert(Regex.literal("Monolake").repeat.matches("MonolakeMonolakeAbleton"))
  }

}
