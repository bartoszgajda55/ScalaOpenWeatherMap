package scalaopenweathermap.client

class ClientBuilder {
  private[client] var apiKey = ""

  private[client] def setApiKey(apiKey: String): ClientBuilder = {
    this.apiKey = apiKey
    this
  }

  private[client] def buildSyncClient(): SyncClient = new SyncClient(this)

  private[client] def buildAsyncClient(): AsyncClient = new AsyncClient(this)
}
