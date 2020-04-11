package scalaopenweathermap

import scalaopenweathermap.client.{ClientFacade, SyncClient}
import scalaopenweathermap.endpoints.{CurrentWeatherService, HourlyForecastService}

import scala.io.Source._

object ScalaOpenWeatherMap extends App {
  val apiKey = fromFile(".env").mkString.substring(7)

  val syncClient: SyncClient = ClientFacade.getSyncClient(apiKey)
//  val currentWeather = new CurrentWeatherService(syncClient)
  val hourlyForecast = new HourlyForecastService(syncClient)
//  val data = currentWeather.getCurrentWeatherData("London")
  val data = hourlyForecast.getHourlyForecast("London")
  println(data)
}
