package com.example.responsi1mobileh1d023117

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.responsi1mobileh1d023117.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initLayout()
        initListener()
    }

    private fun initLayout(){
        binding.layoutHistory.let{
            it.imgIcon.setImageResource(R.drawable.ic_ball)
            it.tvLayout.setText(R.string.history)
        }
        binding.layoutCoach.let{
            it.imgIcon.setImageResource(R.drawable.ic_coach)
            it.tvLayout.setText(R.string.coach)
        }
        binding.layoutTeam.let{
            it.imgIcon.setImageResource(R.drawable.ic_team)
            it.tvLayout.setText(R.string.team)
        }
    }
    private fun initListener() {
        binding.layoutHistory.root.setOnClickListener {
            startActivity(Intent(this, HistoryActivity::class.java))
        }

        binding.layoutCoach.root.setOnClickListener {
            startActivity(Intent(this, CoachActivity::class.java))
        }

         binding.layoutTeam.root.setOnClickListener {
             startActivity(Intent(this, TeamActivity::class.java))
         }
    }
}