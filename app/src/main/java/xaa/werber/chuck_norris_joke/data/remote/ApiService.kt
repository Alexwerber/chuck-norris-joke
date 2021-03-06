package xaa.werber.chuck_norris_joke.data.remote

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import xaa.werber.chuck_norris_joke.data.remote.models.MainResponse

interface ApiService {
    @GET("random/{number}")
    fun getJoke(@Path("number") number: Int): Call<MainResponse>
}