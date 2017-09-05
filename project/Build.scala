import sbt._
import sbt.Keys._
import play.sbt.PlayScala
import play.sbt.routes.RoutesKeys._

object Build extends sbt.Build {
  val buildOrganisation = "example"
  val buildVersion = "0.0.1-SNAPSHOT"
  val buildScalaVersion = "2.12.2"
  val buildScalaOptions = Seq(
    "-unchecked", "-deprecation"
    , "-encoding", "utf8"
    , "-Xelide-below", annotation.elidable.ALL.toString
  )

  lazy val main = Project(id = "playTemplate", base = file(".")).enablePlugins(PlayScala)
    .settings(
      libraryDependencies ++= Seq(
        "com.h2database" % "h2" % "1.4.196",
        "org.scalacheck" %% "scalacheck" % "1.13.4" % "test",
        "org.pegdown" % "pegdown" % "1.0.2" % "test", //used in html report
        "org.scalatest" %% "scalatest" % "3.0.1" % "test",
        "org.seleniumhq.selenium" % "selenium-java" % "2.35.0" % "test",
        "org.slf4j" % "slf4j-api" % "1.7.25",
        "com.storm-enroute" %% "scalameter" % "0.8.2" % "test",
        "ch.qos.logback" % "logback-classic" % "1.1.2",
        "com.typesafe.scala-logging" %% "scala-logging" % "3.7.1",
        "com.typesafe.slick" %% "slick" % "3.2.1",
        "com.typesafe.slick" %% "slick-hikaricp" % "3.2.1"
      )
      , organization := buildOrganisation
      , version := buildVersion
      , scalaVersion := buildScalaVersion
      , scalacOptions := buildScalaOptions
      , routesGenerator := InjectedRoutesGenerator
    )
}