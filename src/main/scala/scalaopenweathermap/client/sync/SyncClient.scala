package scalaopenweathermap.client.sync

import scalaopenweathermap.model.CurrentWeatherData
import sttp.client._
import org.json4s._
import org.json4s.native.JsonMethods._

class SyncClient(builder: SyncClientBuilder) {
  private[sync] val apiKey: String = builder.apiKey
  private[sync] implicit val backend: SttpBackend[Identity, Nothing, NothingT] = HttpURLConnectionBackend()
  private[sync] val apiUrl: String = "https://api.openweathermap.org/data/2.5"
  private[sync] implicit val formats = DefaultFormats

  def getCurrentWeatherData(cityName: String): Option[CurrentWeatherData] = {
    this.getResponse(s"$apiUrl/weather?q=$cityName&appid=$apiKey")

  }

  def getCurrentWeatherData(cityId: Long): Option[CurrentWeatherData] = {
    this.getResponse(s"$apiUrl/weather?id=$cityId&appid=$apiKey")
  }

  def getCurrentWeatherData(lat: Double, lng: Double): Option[CurrentWeatherData] = {
    this.getResponse(s"$apiUrl/weather?lat=$lat&lon=$lng&appid=$apiKey")
  }

  def getCurrentWeatherData(zipCode: Long, countryCode: String): Option[CurrentWeatherData] = {
    this.getResponse(s"$apiUrl/weather?zip=$zipCode,$countryCode&appid=$apiKey")
  }

  private[this] def getResponse(uri: String): Option[CurrentWeatherData] = {
    val request = basicRequest.post(uri"$uri")
    val response = request.send()
    val body = response.body match {
      case Right(x) => Some(parse(x).extract[CurrentWeatherData])
      case Left(x) => None
    }
    body
  }
}

