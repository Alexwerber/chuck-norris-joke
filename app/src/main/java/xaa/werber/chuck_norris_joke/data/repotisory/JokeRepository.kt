package xaa.werber.chuck_norris_joke.data.repotisory

import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import xaa.werber.chuck_norris_joke.data.entity.Joke
import xaa.werber.chuck_norris_joke.data.remote.ApiService
import xaa.werber.chuck_norris_joke.data.remote.models.MainResponse

class JokeRepository(private val apiService: ApiService) {
    private var jokeList: MutableLiveData<List<Joke>> = MutableLiveData()

    fun getData(): MutableLiveData<List<Joke>> = jokeList

    fun loadJokeFromNetwork(number: Int) {
        apiService
                .getJoke(number)
                .enqueue(object: Callback<MainResponse> {
                    override fun onResponse(call: Call<MainResponse>, response: Response<MainResponse>) {
                        if (response.isSuccessful) {
                            response.body()?.let { jokeList.value = it.listOfJokes }
                        }
                    }

                    override fun onFailure(call: Call<MainResponse>, t: Throwable) {

                    }
                })
    }
}