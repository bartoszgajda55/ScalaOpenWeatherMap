package scalaopenweathermap.client.sync

class SyncClientBuilder {
  private[sync] var apiKey = ""

  private[sync] def setApiKey(apiKey: String): SyncClientBuilder = {
    this.apiKey = apiKey
    this
  }

  private[sync] def build(): SyncClient = new SyncClient(this)
}
