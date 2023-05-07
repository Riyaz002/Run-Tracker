package com.riyaz.runtracker.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.riyaz.runtracker.R
import com.riyaz.runtracker.databinding.FragmentSetupBinding

class SetupFragment : Fragment(R.layout.fragment_setup) {
    lateinit var binding: FragmentSetupBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_setup,null, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvContinue.setOnClickListener {
            it.findNavController().navigate(R.id.action_setupFragment_to_runFragment)
        }
    }
}