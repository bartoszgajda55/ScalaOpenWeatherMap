package scalaopenweathermap.endpoints

import scalaopenweathermap.client.Client
import scalaopenweathermap.model.CurrentWeather
import sttp.client._

class CurrentWeatherService[C <: Client](client: C) {
  def getCurrentWeatherData(cityName: String): Option[CurrentWeather] = {
    client.getResponse[CurrentWeather](uri"$standardApiUrl/weather?q=$cityName&appid=${client.apiKey}")
  }

  def getCurrentWeatherData(cityId: Long): Option[CurrentWeather] = {
    client.getResponse[CurrentWeather](uri"$standardApiUrl/weather?id=$cityId&appid=${client.apiKey}")
  }

  def getCurrentWeatherData(lat: Double, lng: Double): Option[CurrentWeather] = {
    client.getResponse[CurrentWeather](uri"$standardApiUrl/weather?lat=$lat&lon=$lng&appid=${client.apiKey}")
  }

  def getCurrentWeatherData(zipCode: Long, countryCode: String): Option[CurrentWeather] = {
    client.getResponse[CurrentWeather](uri"$standardApiUrl/weather?zip=$zipCode,$countryCode&appid=${client.apiKey}")
  }
}
