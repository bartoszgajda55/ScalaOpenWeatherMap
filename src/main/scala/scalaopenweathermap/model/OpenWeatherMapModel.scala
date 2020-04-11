package scalaopenweathermap.model

case class CurrentWeather(
                           coord: Coord,
                           weather: List[Weather],
                           base: String,
                           main: Main,
                           visibility: Int,
                           wind: Wind,
                           clouds: Clouds,
                           dt: Long,
                           timezone: Int,
                           id: Int, name:
                           String,
                           cod: Int)

sealed case class Clouds(all: Int)

sealed case class Coord(lon: Double,lat: Double)

sealed case class Main(temp: Double, feels_like: Double, temp_min: Double, temp_max: Double, pressure: Int, humidity: Int)

sealed case class Weather(id: Int, main: String, description: String, icon: String)

sealed case class Wind(speed: Double, deg: Int)

case class HourlyForecast(
                         cod: String,
                         message: String,
                         cnt: Int,
                         list: List[Forecast],
                         city: City
                         )

sealed case class Forecast(dt: Long, main: Main, weather: List[Weather], clouds: Clouds, wind: Wind, sys: Sys, dt_text: String)

sealed case class Sys(pod: String)

sealed case class City(id: Long, name: String, coord: Coord, country: String, population: String, timezone: Int, sunrise: Long, sunset: Long)
