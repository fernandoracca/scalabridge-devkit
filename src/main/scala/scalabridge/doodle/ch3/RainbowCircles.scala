package scalabridge.doodle.ch3

import doodle.core._
import doodle.syntax._
import doodle.java2d._
import doodle.java2d.effect.Frame

import doodle.effect.Writer._
import doodle.image._
import doodle.image.syntax._

/**
 *  Example that creates a picture on user's home directory.
 */
object RainbowCircles {
  val frame = Frame.fitToPicture().background(Color.black)

  def rainbowCircles(count: Int, color: Color): Image =
    count match {
      case 0 => Image.empty
      case n =>
        val here =
          Image
            .circle((n * 10).toDouble)
            .strokeWidth(3.0)
            .strokeColor(color)
        here.on(rainbowCircles(n - 1, color.spin(33.degrees)))
    }

  def main(args: Array[String]): Unit = {
    val image = rainbowCircles(12, Color.red)
    val imagePath = s"${System.getProperty("user.home")}/rainbow-circles.png"
    image.write[Png](imagePath, frame)
    println(s"Generated image: $imagePath")
  }
}