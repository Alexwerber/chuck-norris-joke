package xaa.werber.chuck_norris_joke.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.android.material.navigation.NavigationBarView
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import kotlinx.android.synthetic.main.activity_main.*
import xaa.werber.chuck_norris_joke.R
import xaa.werber.chuck_norris_joke.ui.fragments.JokeListFragment
import xaa.werber.chuck_norris_joke.ui.fragments.WebFragment
import javax.inject.Inject

class MainActivity : AppCompatActivity(), HasAndroidInjector {
    @Inject
    lateinit var androidInjection: DispatchingAndroidInjector<Any>

    override fun androidInjector(): AndroidInjector<Any> = androidInjection

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottom_navigation.setOnNavigationItemReselectedListener {
            Log.i("wwwww", it.itemId.toString())
            when(it.itemId) {
                R.id.jokes_page -> goToJokePage()
                R.id.web_page -> goToWebPage()
            }
        }
    }

    private fun goToJokePage() {
        this.supportFragmentManager.beginTransaction().replace(R.id.fragment_container, JokeListFragment()).commit()
    }

    private fun goToWebPage() {
        this.supportFragmentManager.beginTransaction().replace(R.id.fragment_container, WebFragment()).commit()
    }

}