name := "ScalaOpenWeatherMap"

version := "1.2.0"

scalaVersion := "2.13.1"

useGpg := true

libraryDependencies ++= Seq(
  "com.softwaremill.sttp.client" %% "core" % "2.0.0-RC6",
  "org.json4s" %% "json4s-native" % "3.6.7"
)

ThisBuild / organization := "com.bartoszgajda.scalaopenweathermap"
ThisBuild / organizationName := "bartoszgajda"
ThisBuild / organizationHomepage := Some(url("http://bartoszgajda.com/"))

ThisBuild / scmInfo := Some(
  ScmInfo(
    url("https://github.com/bartoszgajda55/ScalaOpenWeatherMap"),
    "scm:git@github.com:bartoszgajda55/ScalaOpenWeatherMap.git"
  )
)
ThisBuild / developers := List(
  Developer(
    id    = "0",
    name  = "Bartosz Gajda",
    email = "bg@bartoszgajda.com",
    url   = url("http://bartoszgajda.com")
  )
)

ThisBuild / description := "A Scala wrapper to OpenWeatherMap API using sttp library"
ThisBuild / licenses := List("Apache 2" -> new URL("http://www.apache.org/licenses/LICENSE-2.0.txt"))
ThisBuild / homepage := Some(url("https://github.com/bartoszgajda55/ScalaOpenWeatherMap"))

// Remove all additional repository other than Maven Central from POM
ThisBuild / pomIncludeRepository := { _ => false }
ThisBuild / publishTo := {
  val nexus = "https://oss.sonatype.org/"
  if (isSnapshot.value) Some("snapshots" at nexus + "content/repositories/snapshots")
  else Some("releases" at nexus + "service/local/staging/deploy/maven2")
}
ThisBuild / publishMavenStyle := true