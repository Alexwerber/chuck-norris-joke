package xaa.werber.chuck_norris_joke.di.modules

import dagger.Module
import dagger.Provides
import xaa.werber.chuck_norris_joke.data.remote.ApiService
import xaa.werber.chuck_norris_joke.data.repotisory.JokeRepository
import javax.inject.Singleton

@Module
class RepositoryModule {
    @Provides
    @Singleton
    fun provideJokeRepository(apiService: ApiService): JokeRepository = JokeRepository(apiService)
}