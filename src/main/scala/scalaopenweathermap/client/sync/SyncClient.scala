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
    val request = basicRequest.post(uri"$apiUrl/weather?q=$cityName&appid=$apiKey")
    val response = request.send()
    val body = response.body match {
      case Right(x) => Some(parse(x).extract[CurrentWeatherData])
      case Left(x) => None
    }
    body
  }
}

