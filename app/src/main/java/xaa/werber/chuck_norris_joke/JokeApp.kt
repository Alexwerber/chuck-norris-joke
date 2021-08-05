package xaa.werber.chuck_norris_joke

import android.app.Application
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import xaa.werber.chuck_norris_joke.di.components.DaggerAppComponents
import javax.inject.Inject

class JokeApp : Application(), HasAndroidInjector {
    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    override fun androidInjector(): AndroidInjector<Any> = dispatchingAndroidInjector

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponents.builder().application(this).build().inject(this)
    }

}