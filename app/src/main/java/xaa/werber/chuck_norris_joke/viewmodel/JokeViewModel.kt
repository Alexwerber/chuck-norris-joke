package xaa.werber.chuck_norris_joke.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import xaa.werber.chuck_norris_joke.data.entity.Joke
import xaa.werber.chuck_norris_joke.data.repotisory.JokeRepository

class JokeViewModel(private val repository: JokeRepository): ViewModel() {
    private var jokeList: MutableLiveData<List<Joke>> = MutableLiveData()

    init {
        jokeList = repository.getData()
    }

    fun getJokeList(): MutableLiveData<List<Joke>> = jokeList

    fun getJokeFromNetwork(number: Int) {
        repository.loadJokeFromNetwork(number)
    }
}