package scalaopenweathermap.endpoints

import scalaopenweathermap.client.Client
import scalaopenweathermap.model.CurrentWeatherData
import sttp.client._

class CurrentWeather[C <: Client](client: C) {
  def getCurrentWeatherData(cityName: String): Option[CurrentWeatherData] = {
    client.getResponse[CurrentWeatherData](uri"$apiUrl/weather?q=$cityName&appid=${client.apiKey}")
  }

  def getCurrentWeatherData(cityId: Long): Option[CurrentWeatherData] = {
    client.getResponse[CurrentWeatherData](uri"$apiUrl/weather?id=$cityId&appid=${client.apiKey}")
  }

  def getCurrentWeatherData(lat: Double, lng: Double): Option[CurrentWeatherData] = {
    client.getResponse[CurrentWeatherData](uri"$apiUrl/weather?lat=$lat&lon=$lng&appid=${client.apiKey}")
  }

  def getCurrentWeatherData(zipCode: Long, countryCode: String): Option[CurrentWeatherData] = {
    client.getResponse[CurrentWeatherData](uri"$apiUrl/weather?zip=$zipCode,$countryCode&appid=${client.apiKey}")
  }
}
