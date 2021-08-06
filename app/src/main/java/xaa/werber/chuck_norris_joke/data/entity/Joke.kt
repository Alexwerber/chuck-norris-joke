package xaa.werber.chuck_norris_joke.data.entity

import com.google.gson.annotations.SerializedName

data class Joke(
        @SerializedName("id") val id: Int,
        @SerializedName("joke") val joke: String,
)
