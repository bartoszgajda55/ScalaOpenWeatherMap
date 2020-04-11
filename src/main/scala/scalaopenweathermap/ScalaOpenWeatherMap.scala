package scalaopenweathermap

import scalaopenweathermap.client.{SyncClient, ClientFacade}
import scalaopenweathermap.endpoints.CurrentWeather

import scala.io.Source._

object ScalaOpenWeatherMap extends App {
  val apiKey = fromFile(".env").mkString.substring(7)

  val syncClient: SyncClient = ClientFacade.getSyncClient(apiKey)
  val currentWeather = new CurrentWeather(syncClient)
  val currentWeatherData = currentWeather.getCurrentWeatherData("London")
  println(currentWeatherData)
}
