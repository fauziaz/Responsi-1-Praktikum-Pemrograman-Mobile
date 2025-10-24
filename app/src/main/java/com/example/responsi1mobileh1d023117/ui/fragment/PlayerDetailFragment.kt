package com.example.responsi1mobileh1d023117.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.responsi1mobileh1d023117.R
import com.example.responsi1mobileh1d023117.databinding.FragmentPlayerDetailBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class PlayerDetailFragment(
    private val playerName: String,
    private val playerDOB: String,
    private val playerNation: String,
    private val playerPosition: String
) : BottomSheetDialogFragment() {

    private var _binding: FragmentPlayerDetailBinding? = null
    private val binding get() = _binding!!

    override fun getTheme(): Int = R.style.ThemeOverlay_App_BottomSheetDialog

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentPlayerDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // set text sesuai data
        binding.tvPlayerName.text = playerName
        binding.tvPlayerDOB.text = playerDOB
        binding.tvPlayerNation.text = playerNation
        binding.tvPlayerPosition.text = playerPosition
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
