package scalabridge.week3

object NaiveRegexCalc  {

	// https://regex101.com/
	val SimpleCalc = """\s*(\d+)\s*([\+|\-])\s*(\d+)\s*""".r
	//------------  spaces(numbers)spaces([+ or -])spaces(numbers)spaces ----

	def parse(input: String): Either[String,String] = 
		input match {
			case SimpleCalc(l, op, r, _*) => Right(s"left: $l, op: $op, right: $r")
			case badInput => Left(s"failed parsing: '$badInput'")
		}

	def main(args: Array[String]): Unit = {
		require(args.size == 1, "NaiveRegexCalc <expr>")
		println(parse(args.head))
	}
}