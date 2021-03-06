package xaa.werber.chuck_norris_joke.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.fragment_joke_list.*
import xaa.werber.chuck_norris_joke.R
import xaa.werber.chuck_norris_joke.ui.adapters.JokeListAdapter
import xaa.werber.chuck_norris_joke.viewmodel.JokeViewModel
import xaa.werber.chuck_norris_joke.viewmodel.ViewModelFactory
import javax.inject.Inject

class JokeListFragment: Fragment(R.layout.fragment_joke_list) {
    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private lateinit var viewModel: JokeViewModel

    private val adapter = JokeListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidSupportInjection.inject(this)
        super.onCreate(savedInstanceState)
        activity?.let { it.title = resources.getString(R.string.joke_title) }
    }

    override fun onStart() {
        super.onStart()

        activity?.let { viewModel = ViewModelProvider(this, viewModelFactory).get(JokeViewModel::class.java)}

        joke_recycler_view.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = this@JokeListFragment.adapter
        }

        viewModel.getJokeList().observe(this, {
            adapter.setData(it)
        })

        load_button.setOnClickListener() {
            count_input.text.toString().toIntOrNull()?.let {
                viewModel.getJokeFromNetwork(it)
            }
        }
    }

}