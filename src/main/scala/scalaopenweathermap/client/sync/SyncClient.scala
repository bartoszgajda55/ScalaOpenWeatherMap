package scalaopenweathermap.client.sync

class SyncClient(builder: SyncClientBuilder) {
  private[sync] val apiKey: String = builder.apiKey
}

