package com.example.responsi1mobileh1d023117.ui.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.responsi1mobileh1d023117.data.model.Player
import com.example.responsi1mobileh1d023117.databinding.ListPlayerBinding
import com.example.responsi1mobileh1d023117.ui.PlayerDetailFragment

class PlayerAdapter(
    private val players: List<Player>
) : RecyclerView.Adapter<PlayerAdapter.PlayerViewHolder>() {

    inner class PlayerViewHolder(val binding: ListPlayerBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerViewHolder {
        val binding = ListPlayerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PlayerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PlayerViewHolder, position: Int) {
        val player = players[position]

        holder.binding.tvPlayerName.text = player.name
        holder.binding.tvPlayerNation.text = player.nationality

        val color = when(player.position) {
            "Goalkeeper" -> Color.YELLOW
            "Defence", "Centre-Back", "Left-Back", "Right-Back" -> Color.BLUE
            "Midfield", "Central Midfield", "Attacking Midfield", "Defensive Midfield", "Left Midfield", "Right Winger", "Left Winger" -> Color.GREEN
            "Forward", "Centre-Forward", "Offence" -> Color.RED
            else -> Color.LTGRAY
        }
        holder.binding.cardView.setCardBackgroundColor(color)

        holder.binding.cardView.setOnClickListener {
            val fragment = PlayerDetailFragment(
                player.name,
                player.dateOfBirth,
                player.nationality,
                player.position
            )
            fragment.show((it.context as AppCompatActivity).supportFragmentManager, "playerDetail")
        }
    }

    override fun getItemCount() = players.size
}