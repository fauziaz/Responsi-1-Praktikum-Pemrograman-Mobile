package com.example.responsi1mobileh1d023117

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.responsi1mobileh1d023117.data.model.Player
import com.example.responsi1mobileh1d023117.data.model.Team
import com.example.responsi1mobileh1d023117.databinding.ActivityTeamBinding
import com.example.responsi1mobileh1d023117.ui.adapter.PlayerAdapter
import com.example.responsi1mobileh1d023117.utils.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TeamActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTeamBinding
    private lateinit var adapter: PlayerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTeamBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // setup RecyclerView
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = PlayerAdapter(emptyList())
        binding.recyclerView.adapter = adapter

        fetchPlayers()
    }

    private fun fetchPlayers() {
        RetrofitInstance.api.getTeamData().enqueue(object : Callback<Team> {
            override fun onResponse(call: Call<Team>, response: Response<Team>) {
                if (response.isSuccessful) {
                    response.body()?.let { team ->
                        val players = team.squad.map {
                            Player(
                                it.name,
                                it.position,
                                it.nationality,
                                it.dateOfBirth
                            )
                        }
                        adapter = PlayerAdapter(players)
                        binding.recyclerView.adapter = adapter
                    }
                } else {
                    Toast.makeText(this@TeamActivity, "Failed to get data", Toast.LENGTH_SHORT).show()
                    Log.e("TeamActivity", "Error: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<Team>, t: Throwable) {
                Toast.makeText(this@TeamActivity, t.message, Toast.LENGTH_SHORT).show()
                Log.e("TeamActivity", "Failure: ${t.message}")
            }
        })
    }
}