import sbt._
import Keys._


object Common {
  val settings: Seq[Setting[_]] = Seq(
    organization := "CC",
    version := "1.0",
    scalaVersion := "2.11.7"
  )

  val dependencies: Seq[ModuleID] = Seq(
    "org.scalatestplus.play" %% "scalatestplus-play" % "1.5.1" % Test,
    "mysql" % "mysql-connector-java" % "5.1.36",
    "com.typesafe.play" %% "play-slick" % "2.0.0",
    "com.typesafe.play" %% "play-slick-evolutions" % "2.0.0"
  )
}


