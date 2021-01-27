package space.digitallab.testappforarview.common

import space.digitallab.testappforarview.network.ApiClient
import space.digitallab.testappforarview.network.ApiInterface

object Common {
    private val BASE_URL = "https://api.twitch.tv"
    val apiInterface: ApiInterface
        get() = ApiClient.getClient(BASE_URL).create(ApiInterface::class.java)

}