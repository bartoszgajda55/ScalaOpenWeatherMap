package scalaopenweathermap.model

class OpenWeatherMapModel {}

case class Clouds(all: Int)

case class Coord(lon: Double,lat: Double)

case class Main(temp: Double, feels_like: Double, temp_min: Double, temp_max: Double, pressure: Int, humidity: Int)

case class RootInterface(coord: Coord, weather: Seq[Weather], base: String, main: Main, visibility: Int, wind: Wind, clouds: Clouds,
                         dt: Int, sys: Sys, timezone: Int, id: Int, name: String, cod: Int)

case class Sys(`type`: Int, id: Int, message: Double, country: String, sunrise: Int, sunset: Int)

case class Weather(id: Int, main: String, description: String, icon: String)

case class Wind(speed: Double, deg: Int)
