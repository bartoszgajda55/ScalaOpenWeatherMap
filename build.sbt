name := "ScalaOpenWeatherMap"

version := "1.0.0"

scalaVersion := "2.13.1"

libraryDependencies ++= Seq(
  "com.softwaremill.sttp.client" %% "core" % "2.0.0-RC6",
  "org.json4s" %% "json4s-native" % "3.6.7"
)