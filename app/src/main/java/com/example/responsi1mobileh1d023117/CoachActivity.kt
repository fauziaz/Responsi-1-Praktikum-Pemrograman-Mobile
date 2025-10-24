package com.example.responsi1mobileh1d023117

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.responsi1mobileh1d023117.data.model.Team
import com.example.responsi1mobileh1d023117.utils.RetrofitInstance
import com.example.responsi1mobileh1d023117.databinding.ActivityCoachBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CoachActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCoachBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityCoachBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        fetchCoachData()
    }

    private fun fetchCoachData() {
        RetrofitInstance.api.getTeamData().enqueue(object : Callback<Team> {
            override fun onResponse(call: Call<Team>, response: Response<Team>) {
                if (response.isSuccessful) {
                    response.body()?.let { team ->
                        val coach = team.coach
                        binding.tvCoachName.text = coach.name
                        binding.tvCoachBirth.text = coach.dateOfBirth
                        binding.tvCoachNation.text = coach.nationality
                    }
                } else {
                    Toast.makeText(this@CoachActivity, "Failed to get data", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<Team>, t: Throwable) {
                Toast.makeText(this@CoachActivity, t.message, Toast.LENGTH_SHORT).show()
            }
        })
    }
}