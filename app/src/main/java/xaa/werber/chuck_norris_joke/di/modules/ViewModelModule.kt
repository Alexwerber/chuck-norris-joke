package xaa.werber.chuck_norris_joke.di.modules

import androidx.lifecycle.ViewModel
import dagger.MapKey
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import xaa.werber.chuck_norris_joke.data.repotisory.JokeRepository
import xaa.werber.chuck_norris_joke.viewmodel.JokeViewModel
import xaa.werber.chuck_norris_joke.viewmodel.ViewModelFactory
import javax.inject.Provider
import kotlin.reflect.KClass

@Module
class ViewModelModule {
    @Target(AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER, AnnotationTarget.FUNCTION)
    @Retention(AnnotationRetention.RUNTIME)
    @MapKey
    internal annotation class ViewModelKey(val value: KClass<out ViewModel>)

    @Provides
    fun provideViewModelFactory(providerMap: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>): ViewModelFactory =
            ViewModelFactory(providerMap)

    @Provides
    @IntoMap
    @ViewModelKey(JokeViewModel::class)
    fun provideJokeViewModel(jokeRepository: JokeRepository): ViewModel = JokeViewModel(jokeRepository)
}