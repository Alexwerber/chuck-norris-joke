package xaa.werber.chuck_norris_joke.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import dagger.android.support.AndroidSupportInjection
import xaa.werber.chuck_norris_joke.R

class WebFragment: Fragment(R.layout.fragment_web) {
    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidSupportInjection.inject(this)
        super.onCreate(savedInstanceState)
    }
}