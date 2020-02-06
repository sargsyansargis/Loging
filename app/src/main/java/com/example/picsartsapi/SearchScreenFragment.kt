package com.example.picsartsapi

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.picsartsapi.databinding.FragmentSearchScreenBinding

class SearchScreenFragment : Fragment(){
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentSearchScreenBinding.inflate(inflater)
        return binding.root
    }

}