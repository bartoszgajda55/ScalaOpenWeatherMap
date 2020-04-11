package scalaopenweathermap.client

import sttp.client._
import org.json4s._
import org.json4s.native.JsonMethods._
import sttp.model.Uri

class SyncClient(builder: ClientBuilder) extends Client {
  val apiKey: String = builder.apiKey
  implicit val backend: SttpBackend[Identity, Nothing, NothingT] = HttpURLConnectionBackend()
  implicit val formats: Formats = DefaultFormats
  implicit val manifest: Manifest.type = Manifest

  override def getResponse[A](uri: Uri)(implicit manifest: Manifest[A]): Option[A] = {
    val request = basicRequest.post(uri)
    val response = request.send()
    val body = response.body match {
      case Right(x) => Some(parse(x).extract[A])
      case Left(x) => throw new Exception(x)
    }
    body
  }
}

