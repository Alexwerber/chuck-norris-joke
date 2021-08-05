package xaa.werber.chuck_norris_joke.di.components

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import xaa.werber.chuck_norris_joke.JokeApp
import xaa.werber.chuck_norris_joke.di.modules.RepositoryModule
import xaa.werber.chuck_norris_joke.di.modules.RetrofitModule
import xaa.werber.chuck_norris_joke.di.modules.ViewModelModule
import javax.inject.Singleton

@Component(modules = [
    AndroidInjectionModule::class,
    RepositoryModule::class,
    RetrofitModule::class,
    ViewModelModule::class
])
@Singleton
interface AppComponents {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(app: Application): Builder
        fun build(): AppComponents
    }

    fun inject(app: JokeApp)
}