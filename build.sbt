organization := "uk.co.aiur"
name := "scalabridge-doodle"
version := "0.4.0"

scalaVersion := "2.12.8"

libraryDependencies ++= Seq(
  "org.creativescala" %% "doodle"    % "0.9.7",
  "org.typelevel"     %% "cats-core" % "1.6.0",
  "org.scalatest"     %% "scalatest" % "3.0.8" % "test"
)

initialCommands in console := """
|import doodle.core._
|import doodle.java2d._
|import doodle.java2d.effect.Frame
|import doodle.syntax._
|import doodle.effect.Writer._
|import doodle.image._
|import doodle.image.syntax._
""".trim.stripMargin

cleanupCommands in console := """
|doodle.java2d.effect.Java2dRenderer.stop()
""".trim.stripMargin

scalacOptions ++= List(
"-encoding",
"utf8",
  "-explaintypes",
  "-feature",
  "-deprecation",
  "-unchecked",
  "-Xlint",
  "-Ypartial-unification",
  "-Yrangepos",
  "-Ywarn-dead-code",
  "-Ywarn-inaccessible",
  "-Ywarn-infer-any",
  "-Ywarn-numeric-widen",
  "-Ywarn-unused",
  "-Ywarn-unused-import"
)
