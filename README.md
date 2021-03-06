# ScalaOpenWeatherMap
A Scala wrapper to OpenWeatherMap API using sttp library. Provides both Synchronous and Asynchronous clients.
# Installation
The ScalaOpenWeatherMap package can be added using SBT. Use the following code to do so:
```scala
"com.bartoszgajda.scalaopenweathermap" %% "scalaopenweathermap" % "1.1.0"
```
Remember to change the "1.1.0" with the latest version. This can be found using following [link](https://search.maven.org/search?q=com.bartoszgajda)
# Usage
Before making requests, make sure you have the OpenWeatherMap API key generated. Without it, making requests is not possible. Import either Sync or Async client into your application, and make a simple request:
```scala


// Option 1 - Synchronous Client
val syncClient: SyncClient = ClientFacade.getSyncClient(apiKey)
// Option 2 - Asynchronous Client
val asyncClient: AsyncClient = ClientFacade.getAsyncClient(apiKey)

val currentWeather = new CurrentWeather(syncClient) // or asyncClient
val currentWeatherData = currentWeather.getCurrentWeatherData("London")
println(currentWeatherData)


// Example output:
// Some(CurrentWeatherData(Coord(-0.13,51.51),List(Weather(803,Clouds,broken clouds,04n)),stations,
// Main(278.97,275.63,278.15,279.82,1022,93),9000,Wind(3.1,200),Clouds(75),1579902330,0,2643743,London,200))
```
