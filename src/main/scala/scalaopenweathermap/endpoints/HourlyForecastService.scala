package scalaopenweathermap.endpoints

import scalaopenweathermap.client.Client
import scalaopenweathermap.model.HourlyForecast
import sttp.client._

class HourlyForecastService[C <: Client](client: C) {
  def getHourlyForecast(cityName: String): Option[HourlyForecast] = {
    client.getResponse[HourlyForecast](uri"$proApiUrl/forecast/hourly?q=$cityName&appid=${client.apiKey}")
  }

  def getHourlyForecast(cityId: Long): Option[HourlyForecast] = {
    client.getResponse[HourlyForecast](uri"$proApiUrl/forecast/hourly?id=$cityId&appid=${client.apiKey}")
  }

  def getHourlyForecast(lat: Double, long: Double): Option[HourlyForecast] = {
    client.getResponse[HourlyForecast](uri"$proApiUrl/forecast/hourly?lat=$lat&lon=$long&appid=${client.apiKey}")
  }

  def getHourlyForecast(zipCode: Long, countryCode: String): Option[HourlyForecast] = {
    client.getResponse[HourlyForecast](uri"$proApiUrl/forecast/hourly?zip=$zipCode,$countryCode&appid=${client.apiKey}")
  }
}
