package br.com.netshoesgistchallenge.data.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

const val BASE_URL = "https://api.github.com/"

interface GistApi {

    @GET("gists")
    fun getOwner(): Call<List<GistResponse>>


    companion object {


        operator fun invoke(): GistApi {
            val interceptor = HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }

            val okHttpClient = OkHttpClient.Builder().apply {
                addInterceptor(interceptor)
            }
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient.build())
                .build().create(GistApi::class.java)


        }


    }

}