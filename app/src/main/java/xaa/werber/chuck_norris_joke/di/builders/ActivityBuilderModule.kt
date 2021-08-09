package xaa.werber.chuck_norris_joke.di.builders

import dagger.Module
import dagger.android.ContributesAndroidInjector
import xaa.werber.chuck_norris_joke.ui.activities.MainActivity

@Module
abstract class ActivityBuilderModule {
    @ContributesAndroidInjector(modules = [FragmentsBuilderModule::class])
    abstract fun mainActivity(): MainActivity
}