package scalaopenweathermap.client

import sttp.model._

abstract class Client {
  def apiKey: String
  def getResponse[A](uri: Uri)(implicit manifest: Manifest[A]): Option[A]
}
