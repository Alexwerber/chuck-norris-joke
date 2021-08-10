package xaa.werber.chuck_norris_joke.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import androidx.fragment.app.Fragment
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.fragment_web.*
import xaa.werber.chuck_norris_joke.R
import xaa.werber.chuck_norris_joke.utils.ApiConstants.WEB_URL

class WebFragment: Fragment() {
    private lateinit var webView: WebView

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        webView.saveState(outState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        savedInstanceState?.let { webView.restoreState(it) }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidSupportInjection.inject(this)
        super.onCreate(savedInstanceState)
        activity?.let { it.title = resources.getString(R.string.web_title) }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_web, container, false)

        webView = view.findViewById(R.id.web_view)
        webView.loadUrl(WEB_URL)

        return view
    }
}