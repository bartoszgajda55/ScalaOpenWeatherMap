package scalaopenweathermap.client

object ClientFacade {
  def getSyncClient(apiKey: String = ""): SyncClient = new ClientBuilder().setApiKey(apiKey).buildSyncClient()

  def getAsyncClient(apiKey: String = ""): AsyncClient = new ClientBuilder().setApiKey(apiKey).buildAsyncClient()
}
