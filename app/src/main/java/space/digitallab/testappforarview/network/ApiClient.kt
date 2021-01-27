package space.digitallab.testappforarview.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ApiClient {
    private var retrofit: Retrofit? = null

    fun getClient(baseUrl: String): Retrofit {
        if (retrofit == null) {

            val okHttpClientBuilder = OkHttpClient.Builder()
            val logging = HttpLoggingInterceptor()
            okHttpClientBuilder.addInterceptor(logging)
            logging.setLevel(HttpLoggingInterceptor.Level.HEADERS)
            retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit!!
    }
}