# ScalaOpenWeatherMap
A Scala wrapper to OpenWeatherMap API using sttp library. Provides both Synchronous and Asynchronous(TODO) clients.
# Installation
The ScalaOpenWeatherMap package can be added using SBT. Use the following code to do so:
```scala
"com.bartoszgajda.scalaopenweathermap" %% "scalaopenweathermap" % "1.0.0"
```
Remember to change the "1.0.0" with the latest version. This can be found using following [link](https://search.maven.org/search?q=com.bartoszgajda)
# Usage
Before making requests, make sure you have the OpenWeatherMap API key generated. Without it, making requests is not possible. Import either Sync or Async(TODO) client into your application, and make a simple request:
```scala


val apiKey = "myOpenWeatherMapApiKey"
val client: SyncClient = SyncClientFacade.getSyncClient(apiKey)
val currentWeatherData = client.getCurrentWeatherData("London")
println(currentWeatherData)

// Example output:
// Some(CurrentWeatherData(Coord(-0.13,51.51),List(Weather(803,Clouds,broken clouds,04n)),stations,
// Main(278.97,275.63,278.15,279.82,1022,93),9000,Wind(3.1,200),Clouds(75),1579902330,0,2643743,London,200))
```
