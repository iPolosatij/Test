package space.digitallab.testappforarview.network

import Json4Kotlin_Base
import retrofit2.Call
import retrofit2.http.*


interface ApiInterface{

    @GET("https://api.twitch.tv/kraken/games/top")
    fun getList(
        @Header("Accept") accept: String?,
        @Header("Client-ID") device_id: String?
    ): Call<Json4Kotlin_Base>

}