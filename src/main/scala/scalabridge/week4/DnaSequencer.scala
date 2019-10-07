package scalabridge.week4

import scala.annotation.tailrec


sealed trait Nucleobase {
  def letter : Char
}
case object Cytosine extends Nucleobase {
  override final val letter : Char = 'C'
}
case object Guanine extends Nucleobase {
  override final val letter : Char = 'G'
}
case object Adenine extends Nucleobase {
  override final val letter : Char = 'A'
}
case object Thymine extends Nucleobase {
  override final val letter : Char = 'T'
}

object Nucleobase {

  val nucleoBaseParser: Char => Nucleobase = {
    case 'c' => Cytosine
    case 'g' => Guanine
    case 'a' => Adenine
    case 't' => Thymine
  }

  def parseSequence(sequence: String): List[Nucleobase] =
    sequence.map( nucleoBaseParser).toList
}

object DnaSequencer {

  def main(args: Array[String]): Unit = {
    val miniDnaSequence = args.headOption.getOrElse("TCATTGGA")
    val adtDnaSequence: List[Nucleobase] = Nucleobase.parseSequence(miniDnaSequence.toLowerCase)
    println(adtDnaSequence)

    val guanines = parseGuanines(adtDnaSequence, List.empty[Nucleobase])
    println(guanines)

    val cytocineParser = (n: Nucleobase) => n.letter.toLower == 'c'
    val cytocines = parseAny(adtDnaSequence, cytocineParser, List.empty[Nucleobase])
    println(cytocines)
  }

  /**
  :: is the cons operator. it represents the concatenation of elements as a Linked List
      @see https://en.wikipedia.org/wiki/Linked_list

    T :: CATTGGA :: Nil

    T :: C :: A :: T :: T :: G :: G :: A :: Nil
    C :: ATTGGA  :: Nil
    T :: TTGGA   :: Nil
    Nil
   */
  def parseGuanines(xs: List[Nucleobase], guanines: List[Nucleobase]): List[Nucleobase] = {
    xs match {
      case head :: tail if head.letter.toLower == 'g' => parseGuanines(tail, head :: guanines)
      case head :: tail => parseGuanines(tail, guanines)
      case Nil => guanines
    }
  }

  @tailrec //indicates that this function calls itself as the last operation until there's no more work to do
  def parseAny(xs: List[Nucleobase], f: Nucleobase => Boolean, result: List[Nucleobase]): List[Nucleobase] = {
    xs match {
      case head :: tail if f(head) => parseAny(tail, f, head :: result)
      case _ :: tail               => parseAny(tail, f, result)
      case Nil                     => result //tail recursive
    }
  }
}