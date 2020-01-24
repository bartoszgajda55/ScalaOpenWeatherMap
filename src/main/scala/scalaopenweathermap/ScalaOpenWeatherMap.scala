package scalaopenweathermap

import scalaopenweathermap.client.sync.{SyncClient, SyncClientFacade}
import scala.io.Source._

object ScalaOpenWeatherMap extends App {
  val apiKey = fromFile(".env").mkString.substring(7)

  val syncClient: SyncClient = SyncClientFacade.getSyncClient(apiKey)
  val currentWeatherData = syncClient.getCurrentWeatherData("London")
  println(currentWeatherData)
}
