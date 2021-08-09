package xaa.werber.chuck_norris_joke.di.builders

import dagger.Module
import dagger.android.ContributesAndroidInjector
import xaa.werber.chuck_norris_joke.ui.fragments.JokeListFragment
import xaa.werber.chuck_norris_joke.ui.fragments.WebFragment

@Module
abstract class FragmentsBuilderModule {
    @ContributesAndroidInjector
    abstract fun contributeJokeListFragment(): JokeListFragment

    @ContributesAndroidInjector
    abstract fun contributeWebFragment(): WebFragment
}