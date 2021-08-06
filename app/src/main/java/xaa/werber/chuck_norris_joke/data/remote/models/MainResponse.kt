package xaa.werber.chuck_norris_joke.data.remote.models

import com.google.gson.annotations.SerializedName
import xaa.werber.chuck_norris_joke.data.entity.Joke

data class MainResponse(
        @SerializedName("value") val listOfJokes: List<Joke>
)
