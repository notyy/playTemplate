name := "playTemplate"

version := "1.0.0-SNAPSHOT"

scalaVersion := "2.11.6"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

libraryDependencies ++= Seq(
  "com.typesafe.play" %% "play-slick" % "1.0.0",
  "com.typesafe.play" %% "play-slick-evolutions" % "1.0.0",
  "com.h2database" % "h2" % "1.4.177",
  "org.scalacheck" %% "scalacheck" % "1.11.5" % "test",
  "org.pegdown" % "pegdown" % "1.0.2" % "test", //used in html report
  "org.scalatest" %% "scalatest" % "2.2.1" % "test",
  "org.seleniumhq.selenium" % "selenium-java" % "2.35.0" % "test",
  "org.slf4j" % "slf4j-api" % "1.7.7",
  "com.storm-enroute" %% "scalameter" % "0.6" % "test",
  "ch.qos.logback" % "logback-classic" % "1.1.2",
  "com.typesafe.scala-logging" %% "scala-logging-slf4j" % "2.1.2"
)

routesGenerator := InjectedRoutesGenerator

fork in run := true
