package scalaopenweathermap

import sttp.client._
import scala.io.Source._

object ScalaOpenWeatherMap extends App {
  val cityName = Some("London")
  val apiKey = fromFile(".env").mkString.substring(7)

  val request = basicRequest
    .post(uri"https://api.openweathermap.org/data/2.5/weather?q=$cityName&appid=$apiKey")

  implicit val backend = HttpURLConnectionBackend()
  val response = request.send()

  println(response.body)
  println(response.headers)
}
