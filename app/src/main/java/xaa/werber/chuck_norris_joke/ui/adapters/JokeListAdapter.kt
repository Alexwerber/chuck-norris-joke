package xaa.werber.chuck_norris_joke.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import xaa.werber.chuck_norris_joke.R
import xaa.werber.chuck_norris_joke.data.entity.Joke

class JokeListAdapter: RecyclerView.Adapter<JokeListAdapter.ViewHolder>() {

    private var jokeList: List<Joke> = emptyList()

    fun setData(jokeList: List<Joke>) {
        this.jokeList = jokeList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JokeListAdapter.ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_joke_list, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: JokeListAdapter.ViewHolder, position: Int) {

    }

    override fun getItemCount(): Int = jokeList.size

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    }
}