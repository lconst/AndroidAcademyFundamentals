package com.example.androidacademyfundamentals.screen.details

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.androidacademyfundamentals.R
import com.example.androidacademyfundamentals.data.Actor

class ActorAdapter: RecyclerView.Adapter<ActorAdapter.ActorViewHolder>() {

    private var actorList = listOf<Actor>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActorViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_holder_actor, parent, false)
        return ActorViewHolder(view)
    }

    override fun getItemCount(): Int {
        return actorList.size
    }

    override fun onBindViewHolder(holder: ActorViewHolder, position: Int) {
        holder.onBind(actorList[position])
    }

    fun bindActors(actors: List<Actor>) {
        actorList = actors
        notifyDataSetChanged()
    }

    class ActorViewHolder(view: View): RecyclerView.ViewHolder(view) {

        private val photo: ImageView = view.findViewById(R.id.photo)
        private val name: TextView = view.findViewById(R.id.name)

        fun onBind(actor: Actor) {
            photo.setImageResource(actor.photo)
            name.text = (actor.name + actor.surname)
        }
    }
}