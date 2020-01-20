package scalaopenweathermap.client.sync

object SyncClientFacade {
  def getSyncClient(apiKey: String = ""): SyncClient = new SyncClientBuilder().setApiKey(apiKey).build()
}
